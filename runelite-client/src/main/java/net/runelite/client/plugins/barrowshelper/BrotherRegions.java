package net.runelite.client.plugins.barrowshelper;

import net.runelite.api.NpcID;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;

import java.util.HashMap;
import java.util.Map;

public class BrotherRegions {
    Map<Integer, Crypt> crypts = new HashMap();

    BrotherRegions(){
        crypts.put(
                NpcID.AHRIM_THE_BLIGHTED,
                new Crypt(
                        "ahrim the blighted",
                        20770,
                        new WorldPoint(3551, 9694, 3),
                        new WorldPoint(3561, 9703, 3),
                        new WorldPoint(3564, 3288, 0),
                        new WorldPoint(3567, 3291, 0),
                        Varbits.BARROWS_KILLED_AHRIM
                )
        );
        crypts.put(
                NpcID.DHAROK_THE_WRETCHED,
                new Crypt(
                        "dharok the wretched",
                        20720,
                        new WorldPoint(3549, 9710, 3),
                        new WorldPoint(3559, 9718, 3),
                        new WorldPoint(3573, 3296, 0),
                        new WorldPoint(3577, 3300, 0),
                        Varbits.BARROWS_KILLED_DHAROK
                )
        );
        crypts.put(
                NpcID.GUTHAN_THE_INFESTED,
                new Crypt(
                        "guthan the infested",
                        20722,
                        new WorldPoint(3534, 9699, 3),
                        new WorldPoint(3545, 9707, 3),
                        new WorldPoint(3576, 3279, 0),
                        new WorldPoint(3578, 3282, 0),
                        Varbits.BARROWS_KILLED_GUTHAN
                )
        );
        crypts.put(
                NpcID.KARIL_THE_TAINTED,
                new Crypt(
                        "karil the tainted",
                        20771,
                        new WorldPoint(3546, 9678, 3),
                        new WorldPoint(3557, 9687, 3),
                        new WorldPoint(3564, 3275, 0),
                        new WorldPoint(3567, 3278, 0),
                        Varbits.BARROWS_KILLED_KARIL
                )
        );
        crypts.put(
                NpcID.TORAG_THE_CORRUPTED,
                new Crypt(
                        "torag the corrupted",
                        20721,
                        new WorldPoint(3564, 9683, 3),
                        new WorldPoint(3574, 9692, 3),
                        new WorldPoint(3552, 3282, 0),
                        new WorldPoint(3556, 3285, 0),
                        Varbits.BARROWS_KILLED_TORAG
                )
        );
        crypts.put(
                NpcID.VERAC_THE_DEFILED,
                new Crypt(
                        "verac the defiled",
                        20772,
                        new WorldPoint(3568, 3702, 3),
                        new WorldPoint(3578, 3709, 3),
                        new WorldPoint(3555, 3295, 0),
                        new WorldPoint(3558, 3298, 0),
                        Varbits.BARROWS_KILLED_VERAC
                )
        );
    }
}
