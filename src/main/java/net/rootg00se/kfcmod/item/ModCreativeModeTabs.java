package net.rootg00se.kfcmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.rootg00se.kfcmod.KFCMod;
import net.rootg00se.kfcmod.block.ModBlocks;
import net.rootg00se.kfcmod.potion.ModPotions;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KFCMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> KFC_TAB = CREATIVE_MODE_TABS.register("kfc_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.FRIED_DRUMSTICK.get()))
                    .title(Component.translatable("creativetab.kfcmod.kfc_items"))
                    .displayItems((itemDisplayParams, output) -> {
                        output.accept(ModItems.FRIED_DRUMSTICK.get());
                        output.accept(ModItems.CHICKEN_BUCKET.get());
                        output.accept(ModItems.FAMILY_BUCKET.get());
                        output.accept(ModItems.BREADING.get());
                    }).build()
    );

    public static final RegistryObject<CreativeModeTab> KFC_BLOCKS_TAB = CREATIVE_MODE_TABS.register("kfc_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.BREADING_ORE.get()))
                    .title(Component.translatable("creativetab.kfcmod.kfc_blocks"))
                    .displayItems((itemDisplayParams, output) -> {
                        output.accept(ModBlocks.BREADING_ORE.get());
                        output.accept(ModBlocks.BREADING_DEEPSLATE_ORE.get());
                    }).build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
