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

    public static final FoodProperties FAMILY_BUCKET = new FoodProperties.Builder()
            .nutrition(20)
            .saturationModifier(3)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 5), 1.0f)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800), 1.0f)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 2), 1.0f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500), 1.0f)
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 300), 1.0f)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 1), 1.0f)
            .effect(new MobEffectInstance(MobEffects.JUMP, 600, 1), 1.0f)
            .effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200), 1.0f)
            .effect(new MobEffectInstance(MobEffects.INVISIBILITY, 300), 1.0f)
            .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 200), 1.0f)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 300, 1), 1.0f)
            .effect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 200), 1.0f)
            .effect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 600), 1.0f)
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 200), 1.0f)
            .effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 1), 1.0f)
            .effect(new MobEffectInstance(MobEffects.POISON, 500, 3), 1.0f)
            .effect(new MobEffectInstance(MobEffects.WITHER, 400, 2), 1.0f)
            .effect(new MobEffectInstance(MobEffects.HUNGER, 800, 5), 1.0f)
            .effect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 2), 1.0f)
            .effect(new MobEffectInstance(MobEffects.BLINDNESS, 200), 1.0f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 3), 1.0f)
            .effect(new MobEffectInstance(MobEffects.GLOWING, 60), 1.0f)
            .effect(new MobEffectInstance(MobEffects.LEVITATION, 60), 1.0f)
            .build();
}
