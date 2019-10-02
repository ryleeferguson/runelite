package net.runelite.client.plugins.barrowshelper;
import javax.inject.Inject;
import net.runelite.api.*;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.*;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.NPCManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
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

    Actor lastOpponent;
    private Instant lastTime;

    @Subscribe
    public void onInteractingChanged(InteractingChanged event)
    {
        if (event.getSource() != client.getLocalPlayer())
        {
            return;
        }

        Actor opponentActor = event.getTarget();

        if (opponentActor == null)
        {
            // no longer interacting
            lastTime = Instant.now();
            return;
        }

        lastOpponent = opponentActor;

        if(!(opponentActor instanceof NPC)){
            return;
        }

        checkPrayerAgainst(opponentActor);
    }

    public void checkPrayerAgainst(Actor actor){
        if(actor == null || actor.getName() == null){
            return;
        }

        String actorName = actor.getName().toLowerCase();

        int brotherId = 0;
        Crypt crypt = null;

        for (Map.Entry<Integer, Crypt> cryptItem: brotherRegions.crypts.entrySet()) {
            Crypt iCrypt = cryptItem.getValue();
            if(actorName.equals(iCrypt.getName())){
                brotherId = cryptItem.getKey();
                crypt = iCrypt;
                break;
            }
        }

        if(brotherId == 0){
            return;
        }

        String brotherName = "";
        int prayAgainst = 0;
        switch(brotherId){
            case NpcID.AHRIM_THE_BLIGHTED:
                brotherName = "Ahrim";
                prayAgainst = 1;
                break;

            case NpcID.DHAROK_THE_WRETCHED:
                brotherName = "Dharok";
                prayAgainst = 3;
                break;

            case NpcID.GUTHAN_THE_INFESTED:
                brotherName = "Guthan";
                prayAgainst = 3;
                break;

            case NpcID.KARIL_THE_TAINTED:
                brotherName = "Karil";
                prayAgainst = 2;
                break;

            case NpcID.TORAG_THE_CORRUPTED:
                brotherName = "Torag";
                prayAgainst = 3;
                break;

            case NpcID.VERAC_THE_DEFILED:
                brotherName = "Verac";
                prayAgainst = 3;
                break;

        }

        if(client.getVar(crypt.getKilledVarbit()) > 0){
            checkPrayer(0, false);
        }else{
            if(client.getBoostedSkillLevel(Skill.PRAYER) < 22){
                checkPrayer(prayAgainst, true);
            }else{
                checkPrayer(prayAgainst, false);
            }
        }
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged event)
    {
        if (event.getGameState() == GameState.LOADING)
        {
            wasInCrypt = isInCrypt();
            if(wasInCrypt){
                checkCryptLocation();
            }
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
                checkCryptLocation();
            }
        }
    }

    private boolean isInCrypt()
    {
        return client.getLocalPlayer().getWorldLocation().getRegionID() == CRYPT_REGION_ID;
    }

    BrotherRegions brotherRegions = new BrotherRegions();

    public void checkCryptLocation(){
        int brotherId = 0;
        Crypt crypt = null;

        WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();
        for (Map.Entry<Integer, Crypt> cryptItem: brotherRegions.crypts.entrySet()) {
            Crypt iCrypt = cryptItem.getValue();
            if(pointIsInside(playerLocation, iCrypt.cryptMin, iCrypt.cryptMax)){
                brotherId = cryptItem.getKey();
                break;
            }
        }

        // System.out.println("Player location:  " + playerLocation.getX() + ", " + playerLocation.getY() + ", " + playerLocation.getPlane());

        if(brotherId == 0){
            return;
        }

        String brotherName = "";
        int prayAgainst = 0;
        switch(brotherId){
            case NpcID.AHRIM_THE_BLIGHTED:
                brotherName = "Ahrim";
                prayAgainst = 1;
                break;

            case NpcID.DHAROK_THE_WRETCHED:
                brotherName = "Dharok";
                prayAgainst = 3;
                break;

            case NpcID.GUTHAN_THE_INFESTED:
                brotherName = "Guthan";
                prayAgainst = 3;
                break;

            case NpcID.KARIL_THE_TAINTED:
                brotherName = "Karil";
                prayAgainst = 2;
                break;

            case NpcID.TORAG_THE_CORRUPTED:
                brotherName = "Torag";
                prayAgainst = 3;
                break;

            case NpcID.VERAC_THE_DEFILED:
                brotherName = "Verac";
                prayAgainst = 3;
                break;

        }
//
//        System.out.println("Varbit killed [" + brotherName + "]: " + client.getVar(crypt.getKilledVarbit()));
//        if(client.getVar(crypt.getKilledVarbit()) > 0){
//            checkPrayer(0);
//        }else{
//            checkPrayer(prayAgainst);
//        }

        System.out.println("[" + brotherId + "] You are in crypt of " + brotherName);
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

    public void checkPrayer(int prayAgainst, boolean restore){
        if(prayAgainst == 0){
            System.out.println("Pray against 0");
            if(isAnyPrayerActive()){
                disablePrayer();
            }
            return;
        }

        Prayer prayer = null;
        switch(prayAgainst) {
            case 1:
                prayer = Prayer.PROTECT_FROM_MAGIC;
                break;

            case 2:
                prayer = Prayer.PROTECT_FROM_MISSILES;
                break;

            case 3:
                prayer = Prayer.PROTECT_FROM_MELEE;
                break;
        }

        if(prayer == null){
            return;
        }

        if(client.isPrayerActive(prayer)){
            if(restore){
                sendPrayerCommand();
            }
        }else{
            sendPrayAgainstCommand(prayAgainst, restore);
        }
    }

    private boolean isAnyPrayerActive(){
        for (Prayer pray : Prayer.values())//Check if any prayers are active
        {
            if (client.isPrayerActive(pray))
            {
                return true;
            }
        }

        return false;
    }

    private void disablePrayer(){
        System.out.println("Send disable prayer command");
        // Toggle quick prayer
        sendPrayAgainstCommand(0, false);
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

        if (
            lastOpponent != null &&
            lastTime != null &&
            client.getLocalPlayer().getInteracting() == null
        ){
            if (Duration.between(lastTime, Instant.now()).compareTo(Duration.ofMillis(3000)) > 0){
                System.out.println("No longer interacting");
                lastOpponent = null;
                if(isAnyPrayerActive()) {
                    disablePrayer();
                }
            }
        }
    }

    private void healthChanged(int healthAmount) {
        lastHealth = healthAmount;
        // System.out.println("Health: " + healthAmount);

        if(healthAmount < 50){
            sendEatCommand();
        }
    }

    private void prayerChanged(int prayerAmount) {
        lastPrayer = prayerAmount;
        // System.out.println("Prayer: " + prayerAmount);

        checkPrayerAgainst(lastOpponent);
    }

    public void sendEatCommand() {
        System.out.println("Health below 50 - eat command sent");
        try {
            Runtime.getRuntime().exec("C:\\dev\\RuneLite\\barrowshelper\\ahk\\DoAction.exe eat");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void sendPrayerCommand() {
        System.out.println("Prayer below 24 - restorePrayer command sent");
        try {
            Runtime.getRuntime().exec("C:\\dev\\RuneLite\\barrowshelper\\ahk\\DoAction.exe restorePrayer");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void sendPrayAgainstCommand(int prayAgainst, boolean restore) {
        System.out.println("Prayer against: " + prayAgainst);
        try {
            if(restore){
                Runtime.getRuntime().exec("C:\\dev\\RuneLite\\barrowshelper\\ahk\\DoAction.exe restorePrayAgainst " + prayAgainst);
            }else{
                Runtime.getRuntime().exec("C:\\dev\\RuneLite\\barrowshelper\\ahk\\DoAction.exe prayAgainst " + prayAgainst);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
