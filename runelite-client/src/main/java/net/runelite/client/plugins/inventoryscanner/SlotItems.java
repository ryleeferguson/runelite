package net.runelite.client.plugins.inventoryscanner;

import java.util.HashMap;
import java.util.Map;
import static net.runelite.api.ItemID.*;

public class SlotItems {
    SlotItems()
    {
        init();
    }

    private void init(){
        addFood(POTATO, 1);
        addFood(ONION, 1);
        addFood(CABBAGE, 1);
        addFood(POT_OF_CREAM, 1);
        addFood(CHOPPED_ONION, 1);
        addFood(ANCHOVIES, 1);
        addFood(CABBAGE_1967, 1);

        addFood(TOMATO, 2);
        addFood(CHOPPED_TOMATO, 2);
        addFood(BANANA, 2);
        addFood(SLICED_BANANA, 2);
        addFood(ORANGE, 2);
        addFood(ORANGE_SLICES, 2);
        addFood(ORANGE_CHUNKS, 2);
        addFood(PINEAPPLE_RING, 2);
        addFood(PINEAPPLE_CHUNKS, 2);
        addFood(SPICY_SAUCE, 2);
        addFood(CHEESE, 2);
        addFood(SPINACH_ROLL, 2);
        addFood(LEMON, 2);
        addFood(LEMON_CHUNKS, 2);
        addFood(LEMON_SLICES, 2);
        addFood(LIME, 2);
        addFood(LIME_CHUNKS, 2);
        addFood(LIME_SLICES, 2);
        addFood(DWELLBERRIES, 2);
        addFood(BAT_SHISH, 2);
        addFood(COATED_FROGS_LEGS, 2);
        addFood(FILLETS, 2);
        addFood(FINGERS, 2);
        addFood(FROGBURGER, 2);
        addFood(FROGSPAWN_GUMBO, 2);
        addFood(GREEN_GLOOP_SOUP, 2);
        addFood(GRUBS__LA_MODE, 2);
        addFood(MUSHROOMS, 2);
        addFood(ROAST_FROG, 2);

        addFood(SHRIMPS, 3);
        addFood(COOKED_MEAT, 3);
        addFood(COOKED_CHICKEN, 3);
        addFood(ROE, 3);
        addFood(CHOCOLATE_BAR, 3);
        addFood(LOACH, 3);

        addFood(SARDINE, 4);
        addFood(CAKE, 4);
        addFood(_23_CAKE, 4);
        addFood(SLICE_OF_CAKE, 4);
        addFood(CHOCOLATEY_MILK, 4);
        addFood(BAKED_POTATO, 4);
        addFood(EDIBLE_SEAWEED, 4);
        addFood(MOONLIGHT_MEAD, 4);

        addFood(BREAD, 5);
        addFood(HERRING, 5);
        addFood(CHOCOLATE_CAKE, 5);
        addFood(_23_CHOCOLATE_CAKE, 5);
        addFood(CHOCOLATE_SLICE, 5);
        addFood(COOKED_RABBIT, 5);
        addFood(CHILLI_CON_CARNE, 5);
        addFood(FRIED_MUSHROOMS, 5);
        addFood(FRIED_ONIONS, 5);
        addFood(REDBERRY_PIE, 5);
        addFood(HALF_A_REDBERRY_PIE, 5);
        addFood(CAVIAR, 5);
        addFood(PYSK_FISH_0, 5);
        addFood(PREMADE_WIZ_BLZD, 5);
        addFood(WIZARD_BLIZZARD, 5);
        addFood(PREMADE_SGG, 5);
        addFood(SHORT_GREEN_GUY, 5);
        addFood(PREMADE_DR_DRAGON, 5);
        addFood(DRUNK_DRAGON, 5);
        addFood(PREMADE_CHOC_SDY, 5);
        addFood(CHOC_SATURDAY, 5);
        addFood(GUTHIX_REST1, 5);
        addFood(GUTHIX_REST2, 5);
        addFood(GUTHIX_REST3, 5);
        addFood(GUTHIX_REST4, 5);

        addFood(CHOCICE, 6);
        addFood(MACKEREL, 6);
        addFood(MEAT_PIE, 6);
        addFood(HALF_A_MEAT_PIE, 6);
        addFood(GUANIC_BAT_0, 6);
        addFood(ROAST_BIRD_MEAT, 6);
        addFood(SQUARE_SANDWICH, 6);
        addFood(ROLL, 6);
        addFood(BAGUETTE, 6);
        addFood(TRIANGLE_SANDWICH, 6);
        addFood(GIANT_CARP, 6);
        addFood(GARDEN_PIE, 6);
        addFood(HALF_A_GARDEN_PIE, 6);
        addFood(FISH_PIE, 6);
        addFood(HALF_A_FISH_PIE, 6);

        addFood(TROUT, 7);
        addFood(COD, 7);
        addFood(PLAIN_PIZZA, 7);
        addFood(_12_PLAIN_PIZZA, 7);
        addFood(APPLE_PIE, 7);
        addFood(HALF_AN_APPLE_PIE, 7);
        addFood(ROAST_RABBIT, 7);
        addFood(PREMADE_CH_CRUNCH, 7);
        addFood(CHOCCHIP_CRUNCHIES, 7);
        addFood(PREMADE_SY_CRUNCH, 7);
        addFood(SPICY_CRUNCHIES, 7);
        addFood(BOTANICAL_PIE, 7);
        addFood(HALF_A_BOTANICAL_PIE, 7);

        addFood(PIKE, 8);
        addFood(ROAST_BEAST_MEAT, 8);
        addFood(MEAT_PIZZA, 8);
        addFood(_12_MEAT_PIZZA, 8);
        addFood(PREMADE_WM_CRUN, 8);
        addFood(WORM_CRUNCHIES, 8);
        addFood(PREMADE_TD_CRUNCH, 8);
        addFood(TOAD_CRUNCHIES, 8);
        addFood(EGG_AND_TOMATO, 8);
        addFood(PRAEL_BAT_1, 8);
        addFood(PEACH, 8);
        addFood(SUPHI_FISH_1, 8);
        addFood(PAPAYA_FRUIT, 8);
        addFood(MUSHROOM_PIE, 8);
        addFood(HALF_A_MUSHROOM_PIE, 8);
        addFood(ADMIRAL_PIE, 8);
        addFood(HALF_AN_ADMIRAL_PIE, 8);

        addFood(PREMADE_P_PUNCH, 9);
        addFood(PINEAPPLE_PUNCH, 9);
        addFood(PREMADE_FR_BLAST, 9);
        addFood(FRUIT_BLAST, 9);
        addFood(SALMON, 9);
        addFood(ANCHOVY_PIZZA, 9);
        addFood(_12_ANCHOVY_PIZZA, 9);

        addFood(TUNA, 10);
        addFood(COOKED_CRAB_MEAT, 10);
        addFood(CHOPPED_TUNA, 10);
        addFood(COOKED_CHOMPY, 10);
        addFood(FIELD_RATION, 10);
        addFood(EEL_SUSHI, 10);

        addFood(RAINBOW_FISH, 11);
        addFood(STEW, 11);
        addFood(PINEAPPLE_PIZZA, 11);
        addFood(_12_PINEAPPLE_PIZZA, 11);
        addFood(COOKED_FISHCAKE, 11);
        addFood(PREMADE_VEG_BATTA, 11);
        addFood(VEGETABLE_BATTA, 11);
        addFood(PREMADE_WM_BATTA, 11);
        addFood(WORM_BATTA, 11);
        addFood(PREMADE_TD_BATTA, 11);
        addFood(TOAD_BATTA, 11);
        addFood(PREMADE_CT_BATTA, 11);
        addFood(CHEESETOM_BATTA, 11);
        addFood(PREMADE_FRT_BATTA, 11);
        addFood(FRUIT_BATTA, 11);
        addFood(MUSHROOM__ONION, 11);
        addFood(GIRAL_BAT_2, 11);
        addFood(LAVA_EEL, 11);
        addFood(LECKISH_FISH_2, 11);
        addFood(JUG_OF_WINE, 11);
        addFood(WILD_PIE, 11);
        addFood(HALF_A_WILD_PIE, 11);
        addFood(SUMMER_PIE, 11);
        addFood(HALF_A_SUMMER_PIE, 11);

        addFood(LOBSTER, 12);
        addFood(PREMADE_WORM_HOLE, 12);
        addFood(WORM_HOLE, 12);
        addFood(PREMADE_VEG_BALL, 12);
        addFood(VEG_BALL, 12);
        addFood(GOUT_TUBER, 12);

        addFood(BASS, 13);
        addFood(TUNA_AND_CORN, 13);

        addFood(POTATO_WITH_BUTTER, 14);
        addFood(CHILLI_POTATO, 14);
        addFood(SWORDFISH, 14);
        addFood(PHLUXIA_BAT_3, 14);
        addFood(PUMPKIN, 14);
        addFood(EASTER_EGG, 14);
        addFood(BRAWK_FISH_3, 14);
        addFood(BOTTLE_OF_WINE, 14);

        addFood(PREMADE_TTL, 15);
        addFood(TANGLED_TOADS_LEGS, 15);
        addFood(PREMADE_CHOC_BOMB, 15);
        addFood(CHOCOLATE_BOMB, 15);
        addFood(COOKED_JUBBLY, 15);

        addFood(MONKFISH, 16);
        addFood(POTATO_WITH_CHEESE, 16);
        addFood(EGG_POTATO, 16);

        addFood(MYCIL_FISH_4, 17);
        addFood(KRYKET_BAT_4, 17);

        addFood(COOKED_KARAMBWAN, 18);

        addFood(CURRY, 19);
        addFood(UGTHANKI_KEBAB, 19);
        addFood(UGTHANKI_KEBAB_1885, 19);

        addFood(MUSHROOM_POTATO, 20);
        addFood(SHARK, 20);
        addFood(ROQED_FISH_5, 20);
        addFood(MURNG_BAT_5, 20);
        addFood(STUFFED_SNAKE, 20);
        addFood(PADDLEFISH, 20);

        addFood(SEA_TURTLE, 21);

        addFood(MANTA_RAY, 22);
        addFood(DARK_CRAB, 22);
        addFood(TUNA_POTATO, 22);

        addFood(KYREN_FISH_6, 23);
        addFood(PSYKK_BAT_6, 23);

        addPrayer(PRAYER_POTION1, 7);
        addPrayer(PRAYER_POTION2, 7);
        addPrayer(PRAYER_POTION3, 7);
        addPrayer(PRAYER_POTION4, 7);
    }

    public Map<Integer, FoodItem> foodItems = new HashMap<>();
    public Map<Integer, PrayerItem> prayerItems = new HashMap<>();

    private void addFood(int id, int minHeal)
    {
        addFood(id, minHeal, minHeal);
    }

    private void addFood(int id, int minHeal, int maxHeal){
        FoodItem foodItem = new FoodItem(id, minHeal, maxHeal);
        foodItems.put(id, foodItem);
    }

    private void addPrayer(int id, int restore){
        PrayerItem prayerItem = new PrayerItem(id, restore);
        prayerItems.put(id, prayerItem);
    }
}
