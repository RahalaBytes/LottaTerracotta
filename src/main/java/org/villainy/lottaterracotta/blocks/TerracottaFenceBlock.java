package org.villainy.lottaterracotta.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.villainy.lottaterracotta.config.LottaTerracottaConfig;
import org.villainy.lottaterracotta.objectholders.TerracottaFenceBlocks;

import java.util.stream.Stream;

public class TerracottaFenceBlock extends FenceBlock {

    private boolean isEnabled() {
        return LottaTerracottaConfig.enableFences;
    }

    public TerracottaFenceBlock(DyeColor dyeColor) {
        super(Block.Properties.of(Material.STONE, dyeColor).explosionResistance(1.8F));
        setRegistryName(dyeColor.getSerializedName() + "_terracotta_fence");
    }

    public TerracottaFenceBlock() {
        super(Block.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).explosionResistance(1.8F));
        setRegistryName("terracotta_fence");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if(group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                TerracottaFenceBlocks.UNCOLORED,
                TerracottaFenceBlocks.WHITE,
                TerracottaFenceBlocks.ORANGE,
                TerracottaFenceBlocks.MAGENTA,
                TerracottaFenceBlocks.LIGHT_BLUE,
                TerracottaFenceBlocks.YELLOW,
                TerracottaFenceBlocks.LIME,
                TerracottaFenceBlocks.PINK,
                TerracottaFenceBlocks.GRAY,
                TerracottaFenceBlocks.LIGHT_GRAY,
                TerracottaFenceBlocks.CYAN,
                TerracottaFenceBlocks.PURPLE,
                TerracottaFenceBlocks.BLUE,
                TerracottaFenceBlocks.BROWN,
                TerracottaFenceBlocks.GREEN,
                TerracottaFenceBlocks.RED,
                TerracottaFenceBlocks.BLACK
        );
    }
}
