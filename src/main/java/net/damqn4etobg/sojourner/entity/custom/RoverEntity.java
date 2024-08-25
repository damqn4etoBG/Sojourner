package net.damqn4etobg.sojourner.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class RoverEntity extends Mob {
    public RoverEntity(EntityType<? extends Mob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ARMOR_TOUGHNESS, 2.5f)
                .add(Attributes.FOLLOW_RANGE, 2D);
    }

    @Override
    public boolean isNoGravity() {
        return false;
    }

    @Override
    public boolean isInvulnerable() {
        return true;
    }
}
