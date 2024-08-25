package net.damqn4etobg.sojourner.block.entity;

import net.damqn4etobg.sojourner.block.ModBlocks;
import net.damqn4etobg.sojourner.screen.menu.BlueprintInscriberMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.jarjar.nio.util.Lazy;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class BlueprintInscriberBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler items = createItemHandler();

    public static int SLOT_COUNT = 2;
    public static int BLUEPRINT_SLOT = 0;
    public static int QUILL_SLOT = 1;

    protected final ContainerData data;

    private int progress = 0;
    private int maxProgress = 100;

    public BlueprintInscriberBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BLUEPRINT_INSCRIBER.get(), pos, state);
        this.data = new ContainerData() {

            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> BlueprintInscriberBlockEntity.this.progress;
                    case 1 -> BlueprintInscriberBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> BlueprintInscriberBlockEntity.this.progress = value;
                    case 1 -> BlueprintInscriberBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    private final Lazy<IItemHandler> itemHandler = Lazy.of(() -> items);

    @Nonnull
    private ItemStackHandler createItemHandler() {
        return new ItemStackHandler(SLOT_COUNT) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
            }
        };
    }

    public IItemHandler getItemHandler() {
        return itemHandler.get();
    }

    public Lazy<IItemHandler> getItemHandlerCap() {
        return itemHandler;
    }

    @Override
    public void invalidateCapabilities() {
        super.invalidateCapabilities();
        level.invalidateCapabilities(getBlockPos());
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", items.serializeNBT());
        tag.putInt("progress", this.progress);
        tag.putInt("maxProgress", this.maxProgress);
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        items.deserializeNBT(tag.getCompound("inventory"));
        progress = tag.getInt("progress");
        maxProgress = tag.getInt("maxProgress");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new BlueprintInscriberMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.sojourner.blueprint_inscriber");
    }

    public void drops() {
        BlockEntity blockentity = level.getBlockEntity(getBlockPos());
        if (blockentity instanceof BlueprintInscriberBlockEntity be) {
            ItemStack itemStack = new ItemStack(ModBlocks.BLUEPRINT_INSCRIBER.get().asItem());
            be.saveToItem(itemStack);

            Containers.dropItemStack(this.level, this.worldPosition.getX(), this.worldPosition.getY(), this.worldPosition.getZ(), itemStack);
        }
    }

    public void dropsItems() {
        SimpleContainer inventory = new SimpleContainer(items.getSlots());
        for (int i = 0; i < items.getSlots(); i++) {
            inventory.setItem(i, items.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
