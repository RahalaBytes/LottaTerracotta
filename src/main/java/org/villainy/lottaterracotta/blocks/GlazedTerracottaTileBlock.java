package org.villainy.lottaterracotta.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import org.villainy.lottaterracotta.config.LottaTerracottaConfig;
import org.villainy.lottaterracotta.objectholders.GlazedTerracottaTileBlocks;

import java.util.stream.Stream;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.FACING;

public class GlazedTerracottaTileBlock extends CarpetBlock {
    private boolean isEnabled() {
        return LottaTerracottaConfig.enableTiles;
    }
    public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;

    public GlazedTerracottaTileBlock(DyeColor dyeColor) {
        super(Block.Properties.of(Material.STONE, dyeColor).strength(0.1F));
        setRegistryName(dyeColor.getSerializedName() + "_glazed_terracotta_tile");
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(HORIZONTAL_FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.stateDefinition.any()
                .setValue(HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(HORIZONTAL_FACING, rot.rotate(state.getValue(HORIZONTAL_FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return mirrorIn == Mirror.NONE ? state : state.rotate(mirrorIn.getRotation(state.getValue(HORIZONTAL_FACING)));
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if (group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
    }

    static public Stream<Block> allBlocks() {
        return Stream.of(
                GlazedTerracottaTileBlocks.WHITE,
                GlazedTerracottaTileBlocks.ORANGE,
                GlazedTerracottaTileBlocks.MAGENTA,
                GlazedTerracottaTileBlocks.LIGHT_BLUE,
                GlazedTerracottaTileBlocks.YELLOW,
                GlazedTerracottaTileBlocks.LIME,
                GlazedTerracottaTileBlocks.PINK,
                GlazedTerracottaTileBlocks.GRAY,
                GlazedTerracottaTileBlocks.LIGHT_GRAY,
                GlazedTerracottaTileBlocks.CYAN,
                GlazedTerracottaTileBlocks.PURPLE,
                GlazedTerracottaTileBlocks.BLUE,
                GlazedTerracottaTileBlocks.BROWN,
                GlazedTerracottaTileBlocks.GREEN,
                GlazedTerracottaTileBlocks.RED,
                GlazedTerracottaTileBlocks.BLACK
        );
    }
}
