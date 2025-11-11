package net.rootg00se.kfcmod.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.event.brewing.BrewingRecipeRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.rootg00se.kfcmod.KFCMod;
import net.rootg00se.kfcmod.item.ModItems;
import net.rootg00se.kfcmod.potion.ModPotions;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = KFCMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @SubscribeEvent
    public static void onBrewingRecipeRegister(BrewingRecipeRegisterEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, ModItems.BREADING.get(), ModPotions.DIARRHEA_POTION.getHolder().get());
    }
}