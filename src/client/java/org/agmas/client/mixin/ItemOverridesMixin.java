package org.agmas.client.mixin;

import org.spongepowered.asm.mixin.Mixin;

import org.agmas.Tilted;
import org.agmas.client.duck.ItemOverridesAccessor;

//? if < 1.21.4 {

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.renderer.block.model.ItemOverride;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.item.ItemProperties;

import net.minecraft.client.resources.model.ModelBaker;

import net.minecraft.client.multiplayer.ClientLevel;

import net.minecraft.resources.ResourceLocation;

import org.spongepowered.asm.mixin.Unique;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//? } else {
/*import org.agmas.client.dummy.DM_ItemOverrides;
*///? }

//? if < 1.21.4 {
@Mixin(ItemOverrides.class)
//? } else {
/*@Mixin(DM_ItemOverrides.class)
*///? }

public class ItemOverridesMixin implements ItemOverridesAccessor {
    //? if < 1.21.4 {

    @Unique
    private List<ItemOverride> overrides;

    @Inject(method = "<init>(Lnet/minecraft/client/resources/model/ModelBaker;Lnet/minecraft/client/renderer/block/model/BlockModel;Ljava/util/List;)V", at = @At("RETURN"))
    private void tilted$retrieveOverrides(ModelBaker modelBaker, BlockModel blockModel, List<ItemOverride> list, CallbackInfo ci) {
        overrides = list;
    }

    @Unique
    public @Nullable ItemOverride tilted$getOverride(ItemStack itemStack, ClientLevel level, LivingEntity entity, int i) {
        if (overrides == null) return null;

        @Nullable ItemOverride overrideMatched = null;

        loopOverrides: for (ItemOverride override : overrides) {
            for (ItemOverride.Predicate predicate : override.getPredicates().toList()) {
                ResourceLocation property = predicate.getProperty();
                float threshold = predicate.getValue();

                var function = ItemProperties.getProperty(itemStack, property);
                if (function == null) continue loopOverrides;

                float value = function.call(itemStack, level, entity, i);
                if (value < threshold) continue loopOverrides;
            }

            overrideMatched = override;
        }

        return overrideMatched;
    }

    //? }
}
