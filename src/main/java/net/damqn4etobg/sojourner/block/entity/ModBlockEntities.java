package net.damqn4etobg.sojourner.block.entity;

import net.damqn4etobg.sojourner.Sojourner;
import net.damqn4etobg.sojourner.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Sojourner.MODID);

    public static final Supplier<BlockEntityType<BlueprintInscriberBlockEntity>> BLUEPRINT_INSCRIBER = BLOCK_ENTITIES.register("blueprint_inscriber",
            () -> BlockEntityType.Builder.of(BlueprintInscriberBlockEntity::new, ModBlocks.BLUEPRINT_INSCRIBER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
