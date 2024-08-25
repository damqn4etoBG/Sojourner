package net.damqn4etobg.sojourner.screen.menu;

import net.damqn4etobg.sojourner.block.ModBlocks;
import net.damqn4etobg.sojourner.block.entity.BlueprintInscriberBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.SlotItemHandler;

public class BlueprintInscriberMenu extends AbstractSojournerContainerMenu {

    public final BlueprintInscriberBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public BlueprintInscriberMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(2));
    }

    public BlueprintInscriberMenu(int id, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.BLUEPRINT_INSCRIBER_MENU.get(), id);
        checkContainerSize(inv, 2); // check this also
        blockEntity = (BlueprintInscriberBlockEntity) entity;
        this.level = inv.player.level();
        this.data = data;
        this.BE_INVENTORY_SLOT_COUNT = 2; // define slots
        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.blockEntity.getItemHandlerCap().ifPresent(handler ->{
            this.addSlot(new SlotItemHandler(handler, 0, 80, 42));
            this.addSlot(new SlotItemHandler(handler, 1, 134, 42));
        });

        addDataSlots(data);
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, ModBlocks.BLUEPRINT_INSCRIBER.get());
    }
}
