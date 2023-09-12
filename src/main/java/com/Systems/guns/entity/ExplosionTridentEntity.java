package com.Systems.guns.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ExplosionTridentEntity extends ThrownTrident {

    public ExplosionTridentEntity(EntityType<? extends ThrownTrident> entityType, Level world) {
        super(entityType, world);
    }

    public ExplosionTridentEntity(Level level, Player player, ItemStack ammo) {
        super(level,player,ammo);
    }


    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);

        if (!this.level.isClientSide) {
            // トライデントが地面またはエンティティに当たった場合の処理を追加
          if (hitResult.getType() == HitResult.Type.BLOCK || hitResult.getType() == HitResult.Type.ENTITY) {
                // 地面に当たった場合の処理
                BlockPos blockPos = new BlockPos(hitResult.getLocation());
                ServerLevel serverWorld = (ServerLevel) this.level;

                // 爆発を生成し、トライデントの位置で爆発させる
                serverWorld.explode(this, DamageSource.thrown(this, this.getOwner()), null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 4.0F, true, net.minecraft.world.level.Explosion.BlockInteraction.BREAK);
          }
          // トライデントを回収または消失させる}
            this.discard();
        }
    }

    @Override
    protected ItemStack getPickupItem() {
        return null;
    }
}