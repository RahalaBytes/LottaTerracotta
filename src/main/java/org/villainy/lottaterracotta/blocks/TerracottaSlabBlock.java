package org.villainy.lottaterracotta.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.villainy.lottaterracotta.config.LottaTerracottaConfig;
import org.villainy.lottaterracotta.objectholders.TerracottaSlabBlocks;

import java.util.stream.Stream;

public class TerracottaSlabBlock extends SlabBlock {

    private boolean isEnabled() {
        return LottaTerracottaConfig.enableSlabs;
    }

    public TerracottaSlabBlock(DyeColor dyeColor) {
        super(Block.Properties.copy(Blocks.TERRACOTTA).of(Material.STONE, dyeColor).requiresCorrectToolForDrops().strength(1.25F, 4.2F));
        setRegistryName(dyeColor.getSerializedName() + "_terracotta_slab");
    }

    public TerracottaSlabBlock() {
        super(Block.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).strength(1.25F, 4.2F));
        setRegistryName("terracotta_slab");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if(group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
    }

    static public Stream<Block> allBlocks() {
        return Stream.of(
                TerracottaSlabBlocks.UNCOLORED,
                TerracottaSlabBlocks.WHITE,
                TerracottaSlabBlocks.ORANGE,
                TerracottaSlabBlocks.MAGENTA,
                TerracottaSlabBlocks.LIGHT_BLUE,
                TerracottaSlabBlocks.YELLOW,
                TerracottaSlabBlocks.LIME,
                TerracottaSlabBlocks.PINK,
                TerracottaSlabBlocks.GRAY,
                TerracottaSlabBlocks.LIGHT_GRAY,
                TerracottaSlabBlocks.CYAN,
                TerracottaSlabBlocks.PURPLE,
                TerracottaSlabBlocks.BLUE,
                TerracottaSlabBlocks.BROWN,
                TerracottaSlabBlocks.GREEN,
                TerracottaSlabBlocks.RED,
                TerracottaSlabBlocks.BLACK
        );
    }
}
