package net.rootg00se.kfcmod.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties FRIED_DRUMSTICK = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(0.95f)
            .build();
}
