package org.villainy.lottaterracotta.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import org.villainy.lottaterracotta.config.LottaTerracottaConfig;
import org.villainy.lottaterracotta.objectholders.GlazedTerracottaSlabBlocks;

import java.util.stream.Stream;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.FACING;

public class GlazedTerracottaSlabBlock extends SlabBlock {

    private boolean isEnabled() {
        return LottaTerracottaConfig.enableSlabs;
    }
    public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;

    public GlazedTerracottaSlabBlock(DyeColor dyeColor) {
        super(Block.Properties.of(Material.STONE, dyeColor).requiresCorrectToolForDrops().strength(1.25F, 4.2F));
        setRegistryName(dyeColor.getSerializedName() + "_glazed_terracotta_slab");
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(HORIZONTAL_FACING);
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if(group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockState = super.getStateForPlacement(context);
        return blockState.setValue(HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return mirrorIn == Mirror.NONE ? state : state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    static public Stream<Block> allBlocks() {
        return Stream.of(
                GlazedTerracottaSlabBlocks.WHITE,
                GlazedTerracottaSlabBlocks.ORANGE,
                GlazedTerracottaSlabBlocks.MAGENTA,
                GlazedTerracottaSlabBlocks.LIGHT_BLUE,
                GlazedTerracottaSlabBlocks.YELLOW,
                GlazedTerracottaSlabBlocks.LIME,
                GlazedTerracottaSlabBlocks.PINK,
                GlazedTerracottaSlabBlocks.GRAY,
                GlazedTerracottaSlabBlocks.LIGHT_GRAY,
                GlazedTerracottaSlabBlocks.CYAN,
                GlazedTerracottaSlabBlocks.PURPLE,
                GlazedTerracottaSlabBlocks.BLUE,
                GlazedTerracottaSlabBlocks.BROWN,
                GlazedTerracottaSlabBlocks.GREEN,
                GlazedTerracottaSlabBlocks.RED,
                GlazedTerracottaSlabBlocks.BLACK
        );
    }
}

