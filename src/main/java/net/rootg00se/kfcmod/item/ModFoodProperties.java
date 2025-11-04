package net.rootg00se.kfcmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties FRIED_DRUMSTICK = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(0.95f)
            .build();

    public static final FoodProperties CHICKEN_BUCKET = new FoodProperties.Builder()
            .nutrition(20)
            .saturationModifier(1)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 250, 0),  1.0F)
            .build();
}
