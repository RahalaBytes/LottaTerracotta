package org.villainy.lottaterracotta.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.villainy.lottaterracotta.config.LottaTerracottaConfig;
import org.villainy.lottaterracotta.objectholders.TerracottaLeverBlocks;

import java.util.stream.Stream;

public class TerracottaLeverBlock extends LeverBlock {
    private boolean isEnabled() {
        return LottaTerracottaConfig.enableLevers;
    }

    public TerracottaLeverBlock(DyeColor dyeColor) {
        super(Block.Properties.of(Material.STONE, dyeColor));
        setRegistryName(dyeColor.getSerializedName() + "_terracotta_lever");
    }

    public TerracottaLeverBlock() {
        super(Block.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE));
        setRegistryName("terracotta_lever");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if(group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                TerracottaLeverBlocks.UNCOLORED,
                TerracottaLeverBlocks.WHITE,
                TerracottaLeverBlocks.ORANGE,
                TerracottaLeverBlocks.MAGENTA,
                TerracottaLeverBlocks.LIGHT_BLUE,
                TerracottaLeverBlocks.YELLOW,
                TerracottaLeverBlocks.LIME,
                TerracottaLeverBlocks.PINK,
                TerracottaLeverBlocks.GRAY,
                TerracottaLeverBlocks.LIGHT_GRAY,
                TerracottaLeverBlocks.CYAN,
                TerracottaLeverBlocks.PURPLE,
                TerracottaLeverBlocks.BLUE,
                TerracottaLeverBlocks.BROWN,
                TerracottaLeverBlocks.GREEN,
                TerracottaLeverBlocks.RED,
                TerracottaLeverBlocks.BLACK
        );
    }
}
