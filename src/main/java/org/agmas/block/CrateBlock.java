package org.agmas.block;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import org.agmas.ModItems;

import java.util.List;
import java.util.Random;

public class CrateBlock extends Block {
    public CrateBlock(Properties properties) {
        super(properties);
    }

    List<Item> commonDrops = List.of(
            ModItems.CARNIVORA_SMITHING_TEMPLATE,
            ModItems.JUNKYARD_SMITHING_TEMPLATE,
            ModItems.GOLDENEYE_SMITHING_TEMPLATE,
            ModItems.CARRION_SMITHING_TEMPLATE,
            ModItems.HISTORY_SMITHING_TEMPLATE,
            ModItems.MONEYTALKS_SMITHING_TEMPLATE,
            ModItems.NROSES_SMITHING_TEMPLATE,
            ModItems.REVENANT_SMITHING_TEMPLATE,
            ModItems.RIPPER_SMITHING_TEMPLATE,
            ModItems.SHIPPED_SMITHING_TEMPLATE,
            ModItems.TEMPERED_SMITHING_TEMPLATE,
            ModItems.TRAINING_SMITHING_TEMPLATE,
            ModItems.SUNSET_SMITHING_TEMPLATE,
            ModItems.TIDE_SMITHING_TEMPLATE,
            ModItems.NAUTICAL_SMITHING_TEMPLATE,
            ModItems.PALE_SMITHING_TEMPLATE,
            ModItems.SULFUROUS_SMITHING_TEMPLATE,
            ModItems.ANTIVIRUS_SMITHING_TEMPLATE,
            ModItems.TOTEMIC_SMITHING_TEMPLATE,
            ModItems.WILDFLOWER_SMITHING_TEMPLATE,
            ModItems.DARKSUN_SMITHING_TEMPLATE,
            ModItems.LEGALLY_DISTINCT_BRIMSTONE_SMITHING_TEMPLATE,
            ModItems.FLAMBE_SMITHING_TEMPLATE
    );
    List<Item> uncommonDrops =
            List.of(ModItems.MINED_SMITHING_TEMPLATE,
                    ModItems.HOLIDAY_SMITHING_TEMPLATE,
                    ModItems.HYPERDEATH_SMITHING_TEMPLATE,
                    ModItems.SPECIALOPS_SMITHING_TEMPLATE,
                    ModItems.VIRTUE_SMITHING_TEMPLATE,
                    ModItems.RUNESCAPE_SMITHING_TEMPLATE,
                    ModItems.HAMMER_SMITHING_TEMPLATE,
                    ModItems.KEBAB_SMITHING_TEMPLATE,
                    ModItems.WILLPOWER_SMITHING_TEMPLATE,
                    ModItems.WRATH_SMITHING_TEMPLATE,
                    ModItems.AQUARIUS_SMITHING_TEMPLATE,
                    ModItems.CHERRY_SMITHING_TEMPLATE,
                    ModItems.CLOCKWORK_SMITHING_TEMPLATE,
                    ModItems.COTTONCANDY_SMITHING_TEMPLATE,
                    ModItems.ARMOURED_SMITHING_TEMPLATE,
                    ModItems.CHUD_SMITHING_TEMPLATE,
                    ModItems.BUSINESS_SMITHING_TEMPLATE,
                    ModItems.FRIEND_SMITHING_TEMPLATE,
                    ModItems.STOPWATCH_SMITHING_TEMPLATE,
                    ModItems.SPLIT_SMITHING_TEMPLATE,
                    ModItems.PVP_SMITHING_TEMPLATE,
                    ModItems.WRITER_SMITHING_TEMPLATE,
                    ModItems.FLOWER_SMITHING_TEMPLATE,
                    ModItems.HEARTSTRING_SMITHING_TEMPLATE,
                    ModItems.SENTINAL_SMITHING_TEMPLATE);
    List<Item> rareDrops =
            List.of(ModItems.NOSTALGIA_SMITHING_TEMPLATE,
                    ModItems.ICE_SMITHING_TEMPLATE,
                    ModItems.AWAKENED_SMITHING_TEMPLATE,
                    ModItems.CELESTIAL_SMITHING_TEMPLATE,
                    ModItems.ROAR_SMITHING_TEMPLATE,
                    ModItems.INVERTED_SMITHING_TEMPLATE,
                    ModItems.SOLARIS_SMITHING_TEMPLATE,
                    ModItems.WARLOCK_SMITHING_TEMPLATE,
                    ModItems.GODHOLMS_SMITHING_TEMPLATE,
                    ModItems.ANCIENT_SMITHING_TEMPLATE,
                    ModItems.SHRIMP_SMITHING_TEMPLATE,
                    ModItems.MALWARE_SMITHING_TEMPLATE,
                    ModItems.MISSING_TEXTURE_SMITHING_TEMPLATE,
                    ModItems.GUI_SMITHING_TEMPLATE);
    @Override
    protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
        Random random = new Random();
        int roll = random.nextInt(11);
        if (roll == 0) {
            return List.of(rareDrops.get(random.nextInt(rareDrops.size())).getDefaultInstance());
        } else if (roll < 4) {
            return List.of(uncommonDrops.get(random.nextInt(uncommonDrops.size())).getDefaultInstance());
        } else {
            return List.of(commonDrops.get(random.nextInt(commonDrops.size())).getDefaultInstance());
        }
    }
}
