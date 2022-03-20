package org.villainy.lottaterracotta.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.villainy.lottaterracotta.config.LottaTerracottaConfig;
import org.villainy.lottaterracotta.objectholders.TerracottaLadderBlocks;

import java.util.stream.Stream;

public class TerracottaLadderBlock extends LadderBlock {

    protected static final AABB LADDER_UNROTATED_AABB = org.villainy.sweetconcrete.helper.Shape.getPixeledAABB(1.75, 0, 0, 14.25, 16, 1.5);
    protected static final VoxelShape LADDER_SOUTH_AABB =  Shapes.create(org.villainy.sweetconcrete.helper.Shape.getRotatedAABB(LADDER_UNROTATED_AABB, Direction.SOUTH, false));
    protected static final VoxelShape LADDER_EAST_AABB  = Shapes.create(org.villainy.sweetconcrete.helper.Shape.getRotatedAABB(LADDER_UNROTATED_AABB, Direction.EAST, false));
    protected static final VoxelShape LADDER_WEST_AABB  = Shapes.create(org.villainy.sweetconcrete.helper.Shape.getRotatedAABB(LADDER_UNROTATED_AABB, Direction.WEST, false));
    protected static final VoxelShape LADDER_NORTH_AABB = Shapes.create(org.villainy.sweetconcrete.helper.Shape.getRotatedAABB(LADDER_UNROTATED_AABB, Direction.NORTH, false));

    private boolean isEnabled() {
        return LottaTerracottaConfig.enableLadders;
    }

    public TerracottaLadderBlock(DyeColor dyeColor) {
        super(Block.Properties.of(Material.STONE, dyeColor).noOcclusion().explosionResistance(0.4F).sound(SoundType.LADDER));
        setRegistryName(dyeColor.getSerializedName() + "_terracotta_ladder");
    }

    public TerracottaLadderBlock() {
        super(Block.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).noOcclusion().explosionResistance(0.4F).sound(SoundType.LADDER));
        setRegistryName("terracotta_ladder");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if(group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case NORTH: return LADDER_NORTH_AABB;
            case SOUTH: return LADDER_SOUTH_AABB;
            case WEST: return LADDER_WEST_AABB;
            default: return LADDER_EAST_AABB;
        }
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                TerracottaLadderBlocks.UNCOLORED,
                TerracottaLadderBlocks.WHITE,
                TerracottaLadderBlocks.ORANGE,
                TerracottaLadderBlocks.MAGENTA,
                TerracottaLadderBlocks.LIGHT_BLUE,
                TerracottaLadderBlocks.YELLOW,
                TerracottaLadderBlocks.LIME,
                TerracottaLadderBlocks.PINK,
                TerracottaLadderBlocks.GRAY,
                TerracottaLadderBlocks.LIGHT_GRAY,
                TerracottaLadderBlocks.CYAN,
                TerracottaLadderBlocks.PURPLE,
                TerracottaLadderBlocks.BLUE,
                TerracottaLadderBlocks.BROWN,
                TerracottaLadderBlocks.GREEN,
                TerracottaLadderBlocks.RED,
                TerracottaLadderBlocks.BLACK
        );
    }
}
