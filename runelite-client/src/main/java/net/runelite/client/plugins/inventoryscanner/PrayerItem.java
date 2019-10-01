package net.runelite.client.plugins.inventoryscanner;

import net.runelite.api.Client;
import net.runelite.client.plugins.itemstats.stats.Stats;

public class PrayerItem {
    public int id;
    public int restore;

    PrayerItem(int id, int restore){
        this.id = id;
        this.restore = restore;
    }

    public int getRestoreAmount(Client client){
        double perc = .25;
        int max = Stats.PRAYER.getMaximum(client);
        return ((int) (max * perc)) + restore;
    }
}
