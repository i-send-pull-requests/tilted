package org.agmas.client.mixin;

import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
//? if >=1.21.11 {
import net.minecraft.resources.Identifier;
//? } else {
/*import net.minecraft.resources.ResourceLocation;
*///? }
import net.minecraft.world.item.ItemStack;
import org.agmas.ModComponents;
import org.agmas.Tilted;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = ItemModelResolver.class, priority = 1005)
public class ChangeCrossbowSkinMixin {

    @ModifyVariable(method = "appendItemLayers", at = @At("STORE"), ordinal = 0)
    //? if >=1.21.11 {
    private Identifier changeSkinModel(Identifier modelId, ItemStackRenderState output, ItemStack item) {
    //? } else {
    /*private ResourceLocation changeSkinModel(ResourceLocation modelId, ItemStackRenderState output, ItemStack item) {
    *///? }
        if (item.has(ModComponents.SKIN_COMPONENT)) {
            return Tilted.of(ModComponents.skin(item.get(ModComponents.SKIN_COMPONENT)).name().toLowerCase() +"/"+modelId.getPath());
        }
        return modelId;
    }
}
