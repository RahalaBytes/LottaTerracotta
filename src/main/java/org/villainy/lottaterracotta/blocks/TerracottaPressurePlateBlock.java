package org.villainy.lottaterracotta.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.villainy.lottaterracotta.config.LottaTerracottaConfig;
import org.villainy.lottaterracotta.objectholders.TerracottaPressurePlateBlocks;

import java.util.stream.Stream;

public class TerracottaPressurePlateBlock extends PressurePlateBlock {

    private boolean isEnabled() {
        return LottaTerracottaConfig.enablePressurePlates;
    }

    public TerracottaPressurePlateBlock(DyeColor dyeColor) {
        super(Sensitivity.EVERYTHING,
                Block.Properties.of(Material.STONE, dyeColor)
                        .noCollission()
                        .strength(0.5F));
        setRegistryName(dyeColor.getSerializedName() + "_terracotta_pressure_plate");
    }

    public TerracottaPressurePlateBlock() {
        super(Sensitivity.EVERYTHING,
                Block.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE)
                        .noCollission()
                        .strength(0.5F));
        setRegistryName("terracotta_pressure_plate");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if(group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                TerracottaPressurePlateBlocks.UNCOLORED,
                TerracottaPressurePlateBlocks.WHITE,
                TerracottaPressurePlateBlocks.ORANGE,
                TerracottaPressurePlateBlocks.MAGENTA,
                TerracottaPressurePlateBlocks.LIGHT_BLUE,
                TerracottaPressurePlateBlocks.YELLOW,
                TerracottaPressurePlateBlocks.LIME,
                TerracottaPressurePlateBlocks.PINK,
                TerracottaPressurePlateBlocks.GRAY,
                TerracottaPressurePlateBlocks.LIGHT_GRAY,
                TerracottaPressurePlateBlocks.CYAN,
                TerracottaPressurePlateBlocks.PURPLE,
                TerracottaPressurePlateBlocks.BLUE,
                TerracottaPressurePlateBlocks.BROWN,
                TerracottaPressurePlateBlocks.GREEN,
                TerracottaPressurePlateBlocks.RED,
                TerracottaPressurePlateBlocks.BLACK
        );
    }
}
