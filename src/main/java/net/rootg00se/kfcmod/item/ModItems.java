package net.rootg00se.kfcmod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rootg00se.kfcmod.KFCMod;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, KFCMod.MOD_ID);

    public static final RegistryObject<Item> FRIED_DRUMSTICK = ITEMS.register("fried_drumstick",
            () -> new Item(new Item.Properties().food(ModFoodProperties.FRIED_DRUMSTICK)) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.kfcmod.fried_drumstick"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            }
    );

    public static final RegistryObject<Item> CHICKEN_BUCKET = ITEMS.register("chicken_bucket", () -> new Item(new Item.Properties().food(ModFoodProperties.CHICKEN_BUCKET)) {
        @Override
        public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
            pTooltipComponents.add(Component.translatable("tooltip.kfcmod.chicken_bucket"));
            super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        }
    });

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
