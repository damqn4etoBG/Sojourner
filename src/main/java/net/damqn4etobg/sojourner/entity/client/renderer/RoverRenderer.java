package net.damqn4etobg.sojourner.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.damqn4etobg.sojourner.Sojourner;
import net.damqn4etobg.sojourner.entity.client.ModModelLayers;
import net.damqn4etobg.sojourner.entity.client.model.RoverModel;
import net.damqn4etobg.sojourner.entity.custom.RoverEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RoverRenderer extends MobRenderer<RoverEntity, RoverModel<RoverEntity>> {
    public RoverRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RoverModel<>(pContext.bakeLayer(ModModelLayers.ROVER_LAYER)), 3f);
    }

    @Override
    public ResourceLocation getTextureLocation(RoverEntity pEntity) {
        return new ResourceLocation(Sojourner.MODID, "textures/entity/rover.png");
    }

    @Override
    public void render(RoverEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(0.45f, 0.45f, 0.45f); // 4x smaller since our model is 4x larger
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
