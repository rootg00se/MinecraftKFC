package net.rootg00se.kfcmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.rootg00se.kfcmod.KFCMod;
import net.rootg00se.kfcmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, KFCMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.FRIED_DRUMSTICK.get());
        basicItem(ModItems.CHICKEN_BUCKET.get());
        basicItem(ModItems.FAMILY_BUCKET.get());
        basicItem(ModItems.BREADING.get());
    }
}
