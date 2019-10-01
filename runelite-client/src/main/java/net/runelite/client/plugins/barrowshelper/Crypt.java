package net.runelite.client.plugins.barrowshelper;

import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;

public class Crypt {
    public int id;
    public WorldPoint cryptMin;
    public WorldPoint cryptMax;
    public WorldPoint digMin;
    public WorldPoint digMax;
    public Varbits killedVarbit;

    Crypt(int id, WorldPoint cryptMin, WorldPoint cryptMax, WorldPoint digMin, WorldPoint digMax, Varbits killedVarbit){
        this.id = id;
        this.cryptMin = cryptMin;
        this.cryptMax = cryptMax;
        this.digMin = digMin;
        this.digMax = digMax;
        this.killedVarbit = killedVarbit;
    }
}
