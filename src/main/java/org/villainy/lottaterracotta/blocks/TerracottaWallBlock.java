package org.villainy.lottaterracotta.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.villainy.lottaterracotta.config.LottaTerracottaConfig;
import org.villainy.lottaterracotta.objectholders.TerracottaWallBlocks;

import java.util.stream.Stream;

public class TerracottaWallBlock extends WallBlock {

    private boolean isEnabled() {
        return LottaTerracottaConfig.enableWalls;
    }

    public TerracottaWallBlock(DyeColor dyeColor) {
        super(Block.Properties.of(Material.STONE, dyeColor).requiresCorrectToolForDrops().strength(1.25F, 4.2F));
        setRegistryName(dyeColor.getSerializedName() + "_terracotta_wall");
    }

    public TerracottaWallBlock() {
        super(Block.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).strength(1.25F, 4.2F));
        setRegistryName("terracotta_wall");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if(group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                TerracottaWallBlocks.UNCOLORED,
                TerracottaWallBlocks.WHITE,
                TerracottaWallBlocks.ORANGE,
                TerracottaWallBlocks.MAGENTA,
                TerracottaWallBlocks.LIGHT_BLUE,
                TerracottaWallBlocks.YELLOW,
                TerracottaWallBlocks.LIME,
                TerracottaWallBlocks.PINK,
                TerracottaWallBlocks.GRAY,
                TerracottaWallBlocks.LIGHT_GRAY,
                TerracottaWallBlocks.CYAN,
                TerracottaWallBlocks.PURPLE,
                TerracottaWallBlocks.BLUE,
                TerracottaWallBlocks.BROWN,
                TerracottaWallBlocks.GREEN,
                TerracottaWallBlocks.RED,
                TerracottaWallBlocks.BLACK
        );
    }
}
