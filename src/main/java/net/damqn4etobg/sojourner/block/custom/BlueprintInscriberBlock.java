package net.damqn4etobg.sojourner.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BlueprintInscriberBlock extends Block {
    private final VoxelShape SHAPE = makeShape();

    public BlueprintInscriberBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockPos pos = pContext.getClickedPos();
        Level level = pContext.getLevel();

        if (level.getBlockState(pos.north()).isAir() &&
                level.getBlockState(pos.south()).isAir() &&
                level.getBlockState(pos.east()).isAir() &&
                level.getBlockState(pos.west()).isAir()) {

            return super.getStateForPlacement(pContext);
        } else {
            return null;
        }
    }

    private static VoxelShape makeShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(-0.3125, 0.6875, -0.3125, 1.3125, 0.75, 1.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(-0.40625, 0.65625, -0.28125, -0.28125, 0.78125, 1.28125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(1.28125, 0.65625, -0.28125, 1.40625, 0.78125, 1.28125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(-0.3125, 0, -0.3125, -0.125, 0.6875, -0.125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(1.125, 0, -0.3125, 1.3125, 0.6875, -0.125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(-0.3125, 0, 1.125, -0.125, 0.6875, 1.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(1.125, 0, 1.125, 1.3125, 0.6875, 1.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(-0.28125, 0.65625, 1.28125, 1.28125, 0.78125, 1.40625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(-0.28125, 0.65625, -0.40625, 1.28125, 0.78125, -0.28125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(-0.40625, 0.65625, -0.40625, -0.28125, 0.78125, -0.28125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(-0.40625, 0.65625, 1.28125, -0.28125, 0.78125, 1.40625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(1.28125, 0.65625, 1.28125, 1.40625, 0.78125, 1.40625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(1.28125, 0.65625, -0.40625, 1.40625, 0.78125, -0.28125), BooleanOp.OR);

        return shape;
    }
}
