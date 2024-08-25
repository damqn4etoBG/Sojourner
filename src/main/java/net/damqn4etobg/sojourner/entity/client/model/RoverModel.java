package net.damqn4etobg.sojourner.entity.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.damqn4etobg.sojourner.entity.animations.ModAnimationDefinitions;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class RoverModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart rover;

    public RoverModel(ModelPart root) {
        this.rover = root.getChild("rover");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition rover = partdefinition.addOrReplaceChild("rover", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Body = rover.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(144, 0).addBox(-16.0F, -4.0F, -36.0F, 32.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 4.0F));

        PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 59).addBox(-28.0F, -12.0F, -16.0F, 56.0F, 16.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition WheelRB = rover.addOrReplaceChild("WheelRB", CubeListBuilder.create().texOffs(72, 166).addBox(-7.0F, -6.0F, -6.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-28.0F, -6.0F, 28.0F));

        PartDefinition cube_r2 = WheelRB.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(112, 166).addBox(-4.0F, -6.0F, -6.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition WheelRC = rover.addOrReplaceChild("WheelRC", CubeListBuilder.create().texOffs(152, 166).addBox(-4.0F, -6.0F, -8.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-28.0F, -6.0F, 8.0F));

        PartDefinition cube_r3 = WheelRC.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(32, 157).addBox(-4.0F, -6.0F, -6.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition RightRocker = rover.addOrReplaceChild("RightRocker", CubeListBuilder.create(), PartPose.offset(-22.0F, -13.0F, -11.2F));

        PartDefinition cube_r4 = RightRocker.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0803F, 0.019F, 4.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition cube_r5 = RightRocker.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(144, 59).addBox(-2.0F, -2.0803F, 0.019F, 4.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.2F, -2.7053F, 0.0F, 0.0F));

        PartDefinition cube_r6 = RightRocker.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(68, 134).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -6.6F, 25.2F, -2.8798F, 0.0F, 0.0F));

        PartDefinition cube_r7 = RightRocker.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -7.0F, 25.2F, -0.6545F, 0.0F, 0.0F));

        PartDefinition WheelRF = rover.addOrReplaceChild("WheelRF", CubeListBuilder.create().texOffs(108, 190).addBox(-4.0F, -6.0F, -6.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-28.0F, -6.0F, -24.0F));

        PartDefinition cube_r8 = WheelRF.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(28, 181).addBox(-4.0F, -6.0F, -6.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition WheelLB = rover.addOrReplaceChild("WheelLB", CubeListBuilder.create().texOffs(0, 169).addBox(-4.0F, -6.0F, -6.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(31.0F, -6.0F, 28.0F));

        PartDefinition cube_r9 = WheelLB.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(168, 134).addBox(-4.0F, -6.0F, -6.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition WheelLC = rover.addOrReplaceChild("WheelLC", CubeListBuilder.create().texOffs(180, 93).addBox(-4.0F, -6.0F, -6.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(28.0F, -6.0F, 6.0F));

        PartDefinition cube_r10 = WheelLC.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(176, 69).addBox(-4.0F, -6.0F, -6.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition WheelLF = rover.addOrReplaceChild("WheelLF", CubeListBuilder.create().texOffs(68, 190).addBox(-4.0F, -6.0F, -6.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(28.0F, -6.0F, -24.0F));

        PartDefinition cube_r11 = WheelLF.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(180, 178).addBox(-4.0F, -6.0F, -6.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition LeftRocker = rover.addOrReplaceChild("LeftRocker", CubeListBuilder.create(), PartPose.offset(25.0F, -19.6F, 14.0F));

        PartDefinition cube_r12 = LeftRocker.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(132, 134).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.8798F, 0.0F, 0.0F));

        PartDefinition cube_r13 = LeftRocker.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(104, 134).addBox(-2.0F, -2.0803F, 0.019F, 4.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 6.6F, -25.2F, -0.4363F, 0.0F, 0.0F));

        PartDefinition cube_r14 = LeftRocker.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 147).addBox(-2.0F, -2.0803F, 0.019F, 4.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 6.6F, -24.0F, -2.7053F, 0.0F, 0.0F));

        PartDefinition cube_r15 = LeftRocker.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(144, 27).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4F, 0.0F, -0.6545F, 0.0F, 0.0F));

        PartDefinition CenterThingy = rover.addOrReplaceChild("CenterThingy", CubeListBuilder.create().texOffs(0, 107).addBox(-23.0F, -10.0F, -6.0F, 46.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 123).addBox(-18.0F, -12.0F, -8.0F, 36.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, 16.0F));

        PartDefinition Solar = rover.addOrReplaceChild("Solar", CubeListBuilder.create().texOffs(0, 0).addBox(-22.0F, -2.0F, -60.0F, 44.0F, 3.0F, 56.0F, new CubeDeformation(0.0F))
                .texOffs(92, 107).addBox(-18.0F, -2.0F, -76.0F, 36.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(144, 16).addBox(-18.0F, -2.0F, -84.0F, 28.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(84, 126).addBox(-24.0F, -2.0F, -86.0F, 48.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(84, 130).addBox(-24.0F, -2.0F, -4.0F, 48.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -29.0F, 44.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }


    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animateWalk(ModAnimationDefinitions.ROVER_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        rover.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return rover;
    }
}
