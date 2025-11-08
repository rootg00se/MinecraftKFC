package net.rootg00se.kfcmod.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.rootg00se.kfcmod.KFCMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_BREADING_ORE = registerKey("add_breading_ore");
    public static final ResourceKey<BiomeModifier> ADD_BREADING_DEEPSLATE_ORE = registerKey("add_breading_deepslate_ore");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeature = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(
                ADD_BREADING_ORE,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                        HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.BREADING_ORE_PLACED_KEY)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );

        context.register(
                ADD_BREADING_DEEPSLATE_ORE,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                        HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.BREADING_DEEPSLATE_ORE_PLACED_KEY)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(KFCMod.MOD_ID, name));
    }
}
