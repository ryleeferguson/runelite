package net.runelite.client.plugins.inventoryscanner;

public class FoodItem {
    public int id;
    public int minHeal;
    public int maxHeal;

    FoodItem(int id, int minHeal){
        this(id, minHeal, minHeal);
    }

    FoodItem(int id, int minHeal, int maxHeal){
        this.id = id;
        this.minHeal = minHeal;
        this.maxHeal = maxHeal;
    }

    public int getHealAmount(){
        return (int) Math.floor((minHeal + maxHeal) / 2);
    }
}
