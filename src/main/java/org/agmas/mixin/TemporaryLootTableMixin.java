package org.agmas.mixin;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import org.agmas.ModBlocks;
import org.agmas.ModComponents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;
import java.util.Random;
import java.util.function.Consumer;

@Mixin(LootTable.class)
public abstract class TemporaryLootTableMixin {

    //? if >=26.3 {
    @Inject(method = "getRandomItemsRaw(Lnet/minecraft/world/level/storage/loot/LootContext;Ljava/util/function/Consumer;)V", at = @At("HEAD"))
    public void addText(LootContext context, Consumer<ItemStack> output, CallbackInfo ci) {

        if (new Random().nextInt(0,500) <= 1) {
            output.accept(ModBlocks.CRATE.asItem().getDefaultInstance());
        }
    }
    //? }

}
