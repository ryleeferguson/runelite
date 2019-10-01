package net.runelite.client.plugins.inventoryscanner;

public class Slot {
    public int index;
    public int id;
    public SlotType type;
    public int quantity;

    Slot(int id, int index){
        this(id, index, SlotType.UNKNOWN);
    }

    Slot(int id, int index, SlotType type){
        this.id = id;
        this.index = index;
        this.type = type;
    }
}
