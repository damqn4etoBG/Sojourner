package net.damqn4etobg.sojourner.block.custom;

import com.mojang.serialization.MapCodec;
import net.damqn4etobg.sojourner.block.entity.BlueprintInscriberBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BlueprintInscriberBlock extends BaseEntityBlock {
    public static final MapCodec<BlueprintInscriberBlock> CODEC = simpleCodec(BlueprintInscriberBlock::new);
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    private final VoxelShape SHAPE = makeShape();

    public BlueprintInscriberBlock(Properties pProperties) {
        super(pProperties);
        registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockPos pos = pContext.getClickedPos();
        Level level = pContext.getLevel();

        if (!level.getBlockState(pos.north()).isSolid() && !level.getBlockState(pos.south()).isSolid() && !level.getBlockState(pos.east()).isSolid() &&
                !level.getBlockState(pos.west()).isSolid()) {

            return defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
        } else {
            return null;
        }
    }

    @Override
    public BlockState playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
        if (blockEntity instanceof BlueprintInscriberBlockEntity) {
            if (pPlayer.isCreative()) {
                ((BlueprintInscriberBlockEntity) blockEntity).dropsItems();
            } else {
                ((BlueprintInscriberBlockEntity) blockEntity).drops();
            }
        }
        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
        return pState;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(!level.isClientSide()) {
            BlockEntity entity = level.getBlockEntity(pos);
            if(entity instanceof BlueprintInscriberBlockEntity) {
                player.openMenu((BlueprintInscriberBlockEntity) entity);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BlueprintInscriberBlockEntity(pos, state);
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
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
