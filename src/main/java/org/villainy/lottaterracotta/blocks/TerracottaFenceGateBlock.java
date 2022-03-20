package org.villainy.lottaterracotta.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.villainy.lottaterracotta.config.LottaTerracottaConfig;
import org.villainy.lottaterracotta.objectholders.TerracottaFenceGateBlocks;

import java.util.stream.Stream;

public class TerracottaFenceGateBlock extends FenceGateBlock {

    private boolean isEnabled() {
        return LottaTerracottaConfig.enableFences;
    }

    public TerracottaFenceGateBlock(DyeColor dyeColor) {
        super(Block.Properties.of(Material.STONE, dyeColor)
                .explosionResistance(1.8F)
                .sound(SoundType.STONE));
        setRegistryName(dyeColor.getSerializedName() + "_terracotta_fence_gate");
    }

    public TerracottaFenceGateBlock() {
        super(Block.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE)
                .explosionResistance(1.8F)
                .sound(SoundType.STONE));
        setRegistryName("terracotta_fence_gate");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if(group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                TerracottaFenceGateBlocks.UNCOLORED,
                TerracottaFenceGateBlocks.WHITE,
                TerracottaFenceGateBlocks.ORANGE,
                TerracottaFenceGateBlocks.MAGENTA,
                TerracottaFenceGateBlocks.LIGHT_BLUE,
                TerracottaFenceGateBlocks.YELLOW,
                TerracottaFenceGateBlocks.LIME,
                TerracottaFenceGateBlocks.PINK,
                TerracottaFenceGateBlocks.GRAY,
                TerracottaFenceGateBlocks.LIGHT_GRAY,
                TerracottaFenceGateBlocks.CYAN,
                TerracottaFenceGateBlocks.PURPLE,
                TerracottaFenceGateBlocks.BLUE,
                TerracottaFenceGateBlocks.BROWN,
                TerracottaFenceGateBlocks.GREEN,
                TerracottaFenceGateBlocks.RED,
                TerracottaFenceGateBlocks.BLACK
        );
    }
}
