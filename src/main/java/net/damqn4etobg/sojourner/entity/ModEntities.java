package net.damqn4etobg.sojourner.entity;

import net.damqn4etobg.sojourner.Sojourner;
import net.damqn4etobg.sojourner.entity.custom.RoverEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, Sojourner.MODID);

    // Instead of RegistryObject, we use DeferredHolder or Supplier
    public static final Supplier<EntityType<RoverEntity>> ROVER =
            ENTITY_TYPES.register("rover", () -> EntityType.Builder.of(RoverEntity::new, MobCategory.MISC)
                    .sized(3f, 2f).fireImmune().build("rover"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
