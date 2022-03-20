package org.villainy.lottaterracotta.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StoneButtonBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.villainy.lottaterracotta.config.LottaTerracottaConfig;
import org.villainy.lottaterracotta.objectholders.TerracottaButtonBlocks;

import java.util.stream.Stream;

public class TerracottaButtonBlock extends StoneButtonBlock {

    private boolean isEnabled() {
        return LottaTerracottaConfig.enableButtons;
    }

    public TerracottaButtonBlock(DyeColor dyeColor) {
        super(Block.Properties.of(Material.STONE).color(dyeColor.getMaterialColor()));
        setRegistryName(dyeColor.getSerializedName() + "_terracotta_button");
    }

    public TerracottaButtonBlock() {
        super(Block.Properties.of(Material.STONE).color(MaterialColor.COLOR_ORANGE));
        setRegistryName("terracotta_button");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if(group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                TerracottaButtonBlocks.UNCOLORED,
                TerracottaButtonBlocks.WHITE,
                TerracottaButtonBlocks.ORANGE,
                TerracottaButtonBlocks.MAGENTA,
                TerracottaButtonBlocks.LIGHT_BLUE,
                TerracottaButtonBlocks.YELLOW,
                TerracottaButtonBlocks.LIME,
                TerracottaButtonBlocks.PINK,
                TerracottaButtonBlocks.GRAY,
                TerracottaButtonBlocks.LIGHT_GRAY,
                TerracottaButtonBlocks.CYAN,
                TerracottaButtonBlocks.PURPLE,
                TerracottaButtonBlocks.BLUE,
                TerracottaButtonBlocks.BROWN,
                TerracottaButtonBlocks.GREEN,
                TerracottaButtonBlocks.RED,
                TerracottaButtonBlocks.BLACK
        );
    }
}
