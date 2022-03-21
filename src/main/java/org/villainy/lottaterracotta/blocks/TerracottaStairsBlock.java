package org.villainy.lottaterracotta.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.villainy.lottaterracotta.config.LottaTerracottaConfig;
import org.villainy.lottaterracotta.objectholders.TerracottaStairsBlocks;

import java.util.stream.Stream;

public class TerracottaStairsBlock extends StairBlock {

    private boolean isEnabled() {
        return LottaTerracottaConfig.enableStairs;
    }

    public TerracottaStairsBlock(DyeColor dyeColor, BlockState blockState) {
        super(blockState, Block.Properties.of(Material.STONE, dyeColor).strength(1.8F));
        setRegistryName(dyeColor.getSerializedName() + "_terracotta_stairs");
    }

    public TerracottaStairsBlock(BlockState blockState) {
        super(blockState, Block.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(1.25F, 4.2F));
        setRegistryName("terracotta_stairs");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if(group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                TerracottaStairsBlocks.UNCOLORED,
                TerracottaStairsBlocks.WHITE,
                TerracottaStairsBlocks.ORANGE,
                TerracottaStairsBlocks.MAGENTA,
                TerracottaStairsBlocks.LIGHT_BLUE,
                TerracottaStairsBlocks.YELLOW,
                TerracottaStairsBlocks.LIME,
                TerracottaStairsBlocks.PINK,
                TerracottaStairsBlocks.GRAY,
                TerracottaStairsBlocks.LIGHT_GRAY,
                TerracottaStairsBlocks.CYAN,
                TerracottaStairsBlocks.PURPLE,
                TerracottaStairsBlocks.BLUE,
                TerracottaStairsBlocks.BROWN,
                TerracottaStairsBlocks.GREEN,
                TerracottaStairsBlocks.RED,
                TerracottaStairsBlocks.BLACK
        );
    }
}
