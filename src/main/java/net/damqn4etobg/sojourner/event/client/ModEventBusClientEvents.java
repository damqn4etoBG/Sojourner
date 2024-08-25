package net.damqn4etobg.sojourner.event.client;

import net.damqn4etobg.sojourner.Sojourner;
import net.damqn4etobg.sojourner.entity.client.ModModelLayers;
import net.damqn4etobg.sojourner.entity.client.model.RoverModel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@Mod.EventBusSubscriber(modid = Sojourner.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.ROVER_LAYER, RoverModel::createBodyLayer);
    }
}
