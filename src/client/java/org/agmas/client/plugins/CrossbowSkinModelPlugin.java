package org.agmas.client.plugins;

//? if < 1.21.4 {
import net.minecraft.resources.ResourceLocation;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;

import org.agmas.Tilted;
import org.agmas.attachments.SkinsComponent;

@Environment(EnvType.CLIENT)
public class CrossbowSkinModelPlugin implements ModelLoadingPlugin {
    @Override
    public void onInitializeModelLoader(Context pluginContext) {
        for (SkinsComponent skin : SkinsComponent.values()) {
            pluginContext.addModels(ResourceLocation.fromNamespaceAndPath(Tilted.MOD_ID, "item/" + skin.name().toLowerCase() + "/crossbow"));
            pluginContext.addModels(ResourceLocation.fromNamespaceAndPath(Tilted.MOD_ID, "item/" + skin.name().toLowerCase() + "/crossbow_arrow"));
            pluginContext.addModels(ResourceLocation.fromNamespaceAndPath(Tilted.MOD_ID, "item/" + skin.name().toLowerCase() + "/crossbow_firework"));
            pluginContext.addModels(ResourceLocation.fromNamespaceAndPath(Tilted.MOD_ID, "item/" + skin.name().toLowerCase() + "/crossbow_pulling_0"));
            pluginContext.addModels(ResourceLocation.fromNamespaceAndPath(Tilted.MOD_ID, "item/" + skin.name().toLowerCase() + "/crossbow_pulling_1"));
            pluginContext.addModels(ResourceLocation.fromNamespaceAndPath(Tilted.MOD_ID, "item/" + skin.name().toLowerCase() + "/crossbow_pulling_2"));
        }
    }
}

//? }
