package org.villainy.lottaterracotta.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.villainy.lottaterracotta.config.LottaTerracottaConfig;
import org.villainy.lottaterracotta.objectholders.TerracottaLadderBlocks;

import java.util.stream.Stream;

public class TerracottaLadderBlock extends LadderBlock {

    private boolean isEnabled() {
        return LottaTerracottaConfig.enableLadders;
    }

    public TerracottaLadderBlock(DyeColor dyeColor) {
        super(Block.Properties.of(Material.DECORATION, dyeColor).noOcclusion().strength(0.4F).sound(SoundType.LADDER));
        setRegistryName(dyeColor.getSerializedName() + "_terracotta_ladder");
    }

    public TerracottaLadderBlock() {
        super(Block.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).noOcclusion().strength(0.4F).sound(SoundType.LADDER));
        setRegistryName("terracotta_ladder");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if(group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                TerracottaLadderBlocks.UNCOLORED,
                TerracottaLadderBlocks.WHITE,
                TerracottaLadderBlocks.ORANGE,
                TerracottaLadderBlocks.MAGENTA,
                TerracottaLadderBlocks.LIGHT_BLUE,
                TerracottaLadderBlocks.YELLOW,
                TerracottaLadderBlocks.LIME,
                TerracottaLadderBlocks.PINK,
                TerracottaLadderBlocks.GRAY,
                TerracottaLadderBlocks.LIGHT_GRAY,
                TerracottaLadderBlocks.CYAN,
                TerracottaLadderBlocks.PURPLE,
                TerracottaLadderBlocks.BLUE,
                TerracottaLadderBlocks.BROWN,
                TerracottaLadderBlocks.GREEN,
                TerracottaLadderBlocks.RED,
                TerracottaLadderBlocks.BLACK
        );
    }
}
