package com.Systems.guns.item;

import com.Systems.guns.entity.ExplosionTridentEntity;
import com.Systems.guns.entity.RazerTridentEntity;
import com.Systems.guns.tab.GunsTab;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.dedicated.Settings;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.function.Predicate;

public class RazerGun extends ProjectileWeaponItem {
    public RazerGun() {
        super(new Item.Properties().tab(GunsTab.GUN_TAB).stacksTo(64).rarity(Rarity.COMMON));

    }
    public static final Predicate<ItemStack> RAZERGUN = stack -> stack.getItem() == Items.TNT;

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        Vec3 v3 = player.getViewVector(1F);
        ItemStack itemstac = player.getProjectile(stack);
        ClientLevel levell = Minecraft.getInstance().level;

            ItemStack ammo = new ItemStack(Items.AIR);
            RazerTridentEntity arrow = new RazerTridentEntity(level, player, ammo);
            arrow.shoot(v3.x, v3.y, v3.z, 65F, 0);

            level.addFreshEntity(arrow);
            level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.DRAGON_FIREBALL_EXPLODE, SoundSource.PLAYERS, 1.0F, 1.0F);

            if (!player.getAbilities().instabuild) {
                itemstac.shrink(1);
            }
            stack.hurtAndBreak(1, player, (b) -> {
                b.broadcastBreakEvent(player.getUsedItemHand());
            });

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_FRAME_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);


        return InteractionResultHolder.fail(stack);

    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return RAZERGUN;
    }

    @Override
    public int getDefaultProjectileRange() {
        return 0;
    }
}