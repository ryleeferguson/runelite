package net.runelite.client.plugins.barrowshelper;
import javax.inject.Inject;
import net.runelite.api.*;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.*;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

import java.io.IOException;
import java.util.Map;

@PluginDescriptor(
        name = "Barrows Brothers Helper",
        description = "Links with external program to aid with barrows runs"
)
public class BarrowsHelperPlugin extends Plugin
{
    private static final int CRYPT_REGION_ID = 14231;

    private boolean wasInCrypt = false;

    @Inject
    private OverlayManager overlayManager;

//    @Inject
//    private BarrowsHelperOverlay barrowsOverlay;

    @Inject
    private Client client;

    @Inject
    private ItemManager itemManager;

    @Inject
    private SpriteManager spriteManager;

    @Inject
    private InfoBoxManager infoBoxManager;

    @Inject
    private ChatMessageManager chatMessageManager;

    @Override
    protected void startUp() throws Exception
    {
//        overlayManager.add(barrowsHelperOverlay);
    }

    @Override
    protected void shutDown()
    {
//        overlayManager.remove(barrowsHelperOverlay);
        wasInCrypt = false;
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged event)
    {
        if (event.getGameState() == GameState.LOADING)
        {
            wasInCrypt = isInCrypt();
        }
        else if (event.getGameState() == GameState.LOGGED_IN)
        {
            boolean isInCrypt = isInCrypt();
            if (wasInCrypt && !isInCrypt)
            {
                // exiting crypt
            }
            else if (!wasInCrypt && isInCrypt)
            {
                // entering crypt
            }
        }
        checkCryptLocation();
    }

    private boolean isInCrypt()
    {
        return client.getLocalPlayer().getWorldLocation().getRegionID() == CRYPT_REGION_ID;
    }

    BrotherRegions brotherRegions = new BrotherRegions();

    public void checkCryptLocation(){
        int brotherId = 0;

        WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();
        for (Map.Entry<Integer, Crypt> cryptItem: brotherRegions.crypts.entrySet()) {
            Crypt crypt = cryptItem.getValue();
            if(pointIsInside(playerLocation, crypt.cryptMin, crypt.cryptMax)){
                brotherId = cryptItem.getKey();
                break;
            }
        }

        if(brotherId == 0){
            return;
        }

        String brotherName = "";
        switch(brotherId){
            case NpcID.AHRIM_THE_BLIGHTED:
                brotherName = "Ahrim";
                break;

            case NpcID.DHAROK_THE_WRETCHED:
                brotherName = "Dharok";
                break;

            case NpcID.GUTHAN_THE_INFESTED:
                brotherName = "Guthan";
                break;

            case NpcID.KARIL_THE_TAINTED:
                brotherName = "Karil";
                break;

            case NpcID.TORAG_THE_CORRUPTED:
                brotherName = "Torag";
                break;

            case NpcID.VERAC_THE_DEFILED:
                brotherName = "Verac";
                break;

        }

        System.out.println("[" + brotherId + "] Entered crypt of " + brotherName);
    }

    public boolean pointIsInside(WorldPoint request, WorldPoint minPoint, WorldPoint maxPoint){
        if(request.getPlane() != minPoint.getPlane()){
            return false;
        }

        if(
                request.getX() >= minPoint.getX() && request.getX() <= maxPoint.getX() &&
                request.getY() >= minPoint.getY() && request.getY() <= maxPoint.getY()
        ){
            return true;
        }

        return false;
    }

    private int lastHealth;
    private int lastPrayer;

    @Subscribe
    public void onGameTick(GameTick event) throws IOException {
        int currentHealth = client.getBoostedSkillLevel(Skill.HITPOINTS);
        if(currentHealth != lastHealth){
            healthChanged(currentHealth);
        }
        int currentPrayer = client.getBoostedSkillLevel(Skill.PRAYER);
        if(currentPrayer != lastPrayer){
            prayerChanged(currentPrayer);
        }
    }

    private void healthChanged(int healthAmount) {
        lastHealth = healthAmount;
        System.out.println("Health: " + healthAmount);
        // Runtime.getRuntime().exec("C:\\dev\\RuneLite\\barrowshelper\\ahk\\Debug.exe " + Integer.toString(healthAmount));

        if(healthAmount < 50){
            try {
                sendEatCommand();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void prayerChanged(int prayerAmount) {
        lastPrayer = prayerAmount;
        System.out.println("Prayer: " + prayerAmount);
        // Runtime.getRuntime().exec("C:\\dev\\RuneLite\\barrowshelper\\ahk\\Debug.exe " + Integer.toString(healthAmount));

        if(prayerAmount < 22){
            try {
                sendPrayerCommand();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendEatCommand() throws IOException {
        System.out.println("Health below 50 - eat command sent");
        // Runtime.getRuntime().exec("C:\\dev\\RuneLite\\barrowshelper\\ahk\\DoAction.exe eat");
    }

    public void sendPrayerCommand() throws IOException {
        System.out.println("Prayer below 24 - restorePrayer command sent");
        // Runtime.getRuntime().exec("C:\\dev\\RuneLite\\barrowshelper\\ahk\\DoAction.exe restorePrayer");
    }
}
