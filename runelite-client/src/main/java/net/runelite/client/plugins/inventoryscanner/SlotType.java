package net.runelite.client.plugins.inventoryscanner;

enum SlotType {
    UNKNOWN("unknown"),
    FOOD("food"),
    PRAYER("prayer"),
    SWITCH("switch"),
    SPADE("spade");

    public final String value;

    SlotType(String value){
        this.value = value;
    }
}
