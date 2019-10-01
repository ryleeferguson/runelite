package net.runelite.client.plugins.barrowshelper;

import net.runelite.api.NpcID;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;

import java.util.HashMap;
import java.util.Map;

public class BrotherRegions {
    Map<Integer, Crypt> crypts = new HashMap();

    private void BrotherRegions(){
        crypts.put(
                NpcID.AHRIM_THE_BLIGHTED,
                new Crypt(
                        20770,
                        new WorldPoint(3551, 9703, 3),
                        new WorldPoint(3561, 9694, 3),
                        new WorldPoint(3564, 3291, 0),
                        new WorldPoint(3567, 3288, 0),
                        Varbits.BARROWS_KILLED_AHRIM
                )
        );
        crypts.put(
                NpcID.DHAROK_THE_WRETCHED,
                new Crypt(
                        20720,
                        new WorldPoint(3549, 9718, 3),
                        new WorldPoint(3559, 9710, 3),
                        new WorldPoint(3573, 3300, 0),
                        new WorldPoint(3577, 3296, 0),
                        Varbits.BARROWS_KILLED_DHAROK
                )
        );
        crypts.put(
                NpcID.GUTHAN_THE_INFESTED,
                new Crypt(
                        20722,
                        new WorldPoint(3534, 9707, 3),
                        new WorldPoint(3545, 9699, 3),
                        new WorldPoint(3576, 3282, 0),
                        new WorldPoint(3578, 3279, 0),
                        Varbits.BARROWS_KILLED_GUTHAN
                )
        );
        crypts.put(
                NpcID.KARIL_THE_TAINTED,
                new Crypt(
                        20771,
                        new WorldPoint(3546, 9687, 3),
                        new WorldPoint(3557, 9678, 3),
                        new WorldPoint(3564, 3278, 0),
                        new WorldPoint(3567, 3275, 0),
                        Varbits.BARROWS_KILLED_KARIL
                )
        );
        crypts.put(
                NpcID.TORAG_THE_CORRUPTED,
                new Crypt(
                        20721,
                        new WorldPoint(3564, 9692, 3),
                        new WorldPoint(3574, 9683, 3),
                        new WorldPoint(3552, 3285, 0),
                        new WorldPoint(3556, 3282, 0),
                        Varbits.BARROWS_KILLED_TORAG
                )
        );
        crypts.put(
                NpcID.VERAC_THE_DEFILED,
                new Crypt(
                        20772,
                        new WorldPoint(3568, 9709, 3),
                        new WorldPoint(3578, 3702, 3),
                        new WorldPoint(3555, 3298, 0),
                        new WorldPoint(3558, 3295, 0),
                        Varbits.BARROWS_KILLED_VERAC
                )
        );
    }
}
