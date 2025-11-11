package net.rootg00se.kfcmod.potion;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rootg00se.kfcmod.KFCMod;
import net.rootg00se.kfcmod.effect.ModEffects;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, KFCMod.MOD_ID);

    public static final RegistryObject<Potion> DIARRHEA_POTION = POTIONS.register("diarrhea_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.DIARRHEA.getHolder().get(), 300, 0))
    );

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
