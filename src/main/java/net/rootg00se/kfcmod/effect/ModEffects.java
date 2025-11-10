package net.rootg00se.kfcmod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rootg00se.kfcmod.KFCMod;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, KFCMod.MOD_ID);

    public static RegistryObject<MobEffect> DIARRHEA = MOB_EFFECTS.register("diarrhea",
            () -> new DiarrheaEffect(MobEffectCategory.HARMFUL, 0x8B4513)
    );

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
