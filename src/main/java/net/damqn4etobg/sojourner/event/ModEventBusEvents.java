package net.damqn4etobg.sojourner.event;

import net.damqn4etobg.sojourner.Sojourner;
import net.damqn4etobg.sojourner.entity.ModEntities;
import net.damqn4etobg.sojourner.entity.custom.RoverEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@Mod.EventBusSubscriber(modid = Sojourner.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.ROVER.get(), RoverEntity.createAttributes().build());
    }
}
