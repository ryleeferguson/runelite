package net.runelite.client.plugins.inventoryscanner;

import java.util.HashMap;

public class InventoryData {
    public String switchState;
    public HashMap<Integer, Slot> inventory = new HashMap<Integer, Slot>();
    public HashMap<String, BarrowBrother> brothers = new HashMap<String, BarrowBrother>();
}
