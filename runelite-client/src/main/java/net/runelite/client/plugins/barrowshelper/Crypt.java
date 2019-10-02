package net.runelite.client.plugins.barrowshelper;

import lombok.Getter;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;

public class Crypt {
    @Getter
    public int id;
    public WorldPoint cryptMin;
    public WorldPoint cryptMax;
    public WorldPoint digMin;
    public WorldPoint digMax;
    @Getter
    public Varbits killedVarbit;
    @Getter
    public String name;

    Crypt(String name, int id, WorldPoint cryptMin, WorldPoint cryptMax, WorldPoint digMin, WorldPoint digMax, Varbits killedVarbit){
        this.name = name;
        this.id = id;
        this.cryptMin = cryptMin;
        this.cryptMax = cryptMax;
        this.digMin = digMin;
        this.digMax = digMax;
        this.killedVarbit = killedVarbit;
    }
}
