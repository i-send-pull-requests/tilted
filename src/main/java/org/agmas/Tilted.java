package org.agmas;

import net.fabricmc.api.ModInitializer;

//? if <26.3 {
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
//? }
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
//? if >=1.21.11 {
import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
//? } else {
/*import net.minecraft.resources.ResourceLocation;
*///? }
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.agmas.network.ServerboundADSPacket;
import org.agmas.network.ServerboundLeanPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public class Tilted implements ModInitializer {
	public static final String MOD_ID = "tilted";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//? if >=1.21.11 {
	public static Identifier of(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID,path);
	}
	public static Identifier ofVannila(String path) {
		return Identifier.fromNamespaceAndPath("minecraft",path);
	}
	//? } else {
	/*public static ResourceLocation of(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID,path);
	}
	public static ResourceLocation ofVannila(String path) {
		return ResourceLocation.fromNamespaceAndPath("minecraft",path);
	}
	*///? }

	@Override
	public void onInitialize() {
		ModAttachments.init();
		ModComponents.init();
		ModMenuTypes.init();
		ModItems.init();
		ModBlocks.init();

		LOGGER.info("I HATE https://modrinth.com/user/Elysieon!!! IF YOU SEE THIS MESSAGE MAKE SURE TO SEND MALICE AND DESPAIR TO https://www.youtube.com/@Elysieon!!! And you too powercyphe");

		//? if >=26.1 {
		PayloadTypeRegistry.serverboundPlay().register(ServerboundLeanPacket.TYPE, ServerboundLeanPacket.CODEC);
		PayloadTypeRegistry.serverboundPlay().register(ServerboundADSPacket.TYPE, ServerboundADSPacket.CODEC);
		//? } else {
		/*PayloadTypeRegistry.playC2S().register(ServerboundLeanPacket.TYPE, ServerboundLeanPacket.CODEC);
		PayloadTypeRegistry.playC2S().register(ServerboundADSPacket.TYPE, ServerboundADSPacket.CODEC);

		*///? }

		ServerPlayNetworking.registerGlobalReceiver(ServerboundLeanPacket.TYPE, ((payload, context) -> {
			context.player().setAttached(ModAttachments.LEANING_DIRECTION, payload.leaning());
		}));
		ServerPlayNetworking.registerGlobalReceiver(ServerboundADSPacket.TYPE, ((payload, context) -> {
			context.player().setAttached(ModAttachments.IS_AIMING, payload.isAdsing());
		}));

		//? if <26.3 {
		LootTableEvents.MODIFY_DROPS.register(((key, tableBuilder, source) -> {
			if (!tableBuilder.hasParameter(LootContextParams.BLOCK_STATE) && !tableBuilder.hasParameter(LootContextParams.DAMAGE_SOURCE)) {
				if (new Random().nextInt(0, 6) <= 1) {
					source.add(ModBlocks.CRATE.asItem().getDefaultInstance());
				}
			}
			if (new Random().nextInt(0, 1500) <= 1) {
				source.add(ModBlocks.CRATE.asItem().getDefaultInstance());
			}
		}));
		//? }
	}
}