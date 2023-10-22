package com.Systems.guns.entity;

import com.mojang.math.Vector3d;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import static net.minecraft.core.particles.DustParticleOptions.REDSTONE_PARTICLE_COLOR;

public class RazerTridentEntity extends ThrownTrident {
    public RazerTridentEntity(EntityType<? extends ThrownTrident> entityType, Level world) {
        super(entityType, world);
    }

    public RazerTridentEntity(Level level, Player player, ItemStack ammo) {
        super(level,player,ammo);
    }


    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);

        if (!this.level.isClientSide) {
            BlockPos hitPos = new BlockPos(hitResult.getLocation());
            ClientLevel levell = Minecraft.getInstance().level;

            // トライデントの位置からターゲット位置までのベクトルを計算
            Vec3 tridentPos = this.position();
            Vec3 targetPos = hitResult.getLocation();
            Vec3 direction = targetPos.subtract(tridentPos);

            // パーティクルを生成し、トライデントの位置からターゲット位置まで追従させる
            double distance = direction.length();
            direction = direction.normalize();

            for (double i = 0; i < distance; i += 0.125) {
                Vec3 particlePos = tridentPos.add(direction.scale(i));
                levell.addParticle(ParticleTypes.SONIC_BOOM, particlePos.x, particlePos.y, particlePos.z, 0.0,1.0,3.0);
            }
            ServerLevel serverWorld = (ServerLevel) this.level;

            // 爆発を生成し、トライデントの位置で爆発させる
            serverWorld.explode(this, DamageSource.thrown(this, this.getOwner()), null, hitPos.getX(), hitPos.getY(), hitPos.getZ(), 8.0F, true, net.minecraft.world.level.Explosion.BlockInteraction.BREAK);

            // トライデントを回収または消失させる
            this.discard();
        }
    }

    @Override
    protected ItemStack getPickupItem() {
        return null;
    }
}