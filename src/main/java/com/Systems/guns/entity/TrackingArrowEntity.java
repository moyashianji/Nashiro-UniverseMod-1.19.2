package com.Systems.guns.entity;


import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TrackingArrowEntity extends AbstractArrow {

    public TrackingArrowEntity(EntityType<? extends TrackingArrowEntity> entityType, Level world) {
        super(entityType, world);
    }

    public TrackingArrowEntity(Level world, LivingEntity shooter) {
        super(EntityType.ARROW, shooter, world);
    }

    @Override
    protected ItemStack getPickupItem() {
        return null;
    }
}