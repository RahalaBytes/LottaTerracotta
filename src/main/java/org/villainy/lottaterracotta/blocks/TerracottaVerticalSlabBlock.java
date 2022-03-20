package org.villainy.lottaterracotta.blocks;

import com.teamabnormals.blueprint.common.block.VerticalSlabBlock;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.villainy.lottaterracotta.config.LottaTerracottaConfig;
import org.villainy.lottaterracotta.objectholders.TerracottaVerticalSlabBlocks;

import java.util.stream.Stream;

public class TerracottaVerticalSlabBlock extends VerticalSlabBlock {
    private boolean isEnabled() {
        return LottaTerracottaConfig.enableVerticalSlabs;
    }

    public TerracottaVerticalSlabBlock(DyeColor dyeColor) {
        super(Block.Properties.of(Material.STONE, dyeColor).explosionResistance(1.8F));
        setRegistryName(dyeColor.getSerializedName() + "_terracotta_vertical_slab");
    }

    public TerracottaVerticalSlabBlock() {
        super(Block.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).explosionResistance(1.8F));
        setRegistryName("terracotta_vertical_slab");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if(group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
    }

    static public Stream<Block> allBlocks() {
        return Stream.of(
                TerracottaVerticalSlabBlocks.UNCOLORED,
                TerracottaVerticalSlabBlocks.WHITE,
                TerracottaVerticalSlabBlocks.ORANGE,
                TerracottaVerticalSlabBlocks.MAGENTA,
                TerracottaVerticalSlabBlocks.LIGHT_BLUE,
                TerracottaVerticalSlabBlocks.YELLOW,
                TerracottaVerticalSlabBlocks.LIME,
                TerracottaVerticalSlabBlocks.PINK,
                TerracottaVerticalSlabBlocks.GRAY,
                TerracottaVerticalSlabBlocks.LIGHT_GRAY,
                TerracottaVerticalSlabBlocks.CYAN,
                TerracottaVerticalSlabBlocks.PURPLE,
                TerracottaVerticalSlabBlocks.BLUE,
                TerracottaVerticalSlabBlocks.BROWN,
                TerracottaVerticalSlabBlocks.GREEN,
                TerracottaVerticalSlabBlocks.RED,
                TerracottaVerticalSlabBlocks.BLACK
        );
    }
}

