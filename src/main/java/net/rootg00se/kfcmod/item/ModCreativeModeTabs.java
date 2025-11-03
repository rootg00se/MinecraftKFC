package net.rootg00se.kfcmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.rootg00se.kfcmod.KFCMod;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KFCMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> KFC_TAB = CREATIVE_MODE_TABS.register("kfc_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.FRIED_DRUMSTICK.get()))
                    .title(Component.translatable("creativetab.kfcmod.kfc_items"))
                    .displayItems((itemDisplayParams, output) -> {
                        output.accept(ModItems.FRIED_DRUMSTICK.get());
                    }).build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
