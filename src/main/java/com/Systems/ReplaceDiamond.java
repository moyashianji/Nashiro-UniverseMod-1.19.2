package com.Systems;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Objects;

import static com.main.reference.diamondflag;

public class ReplaceDiamond {
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        int radius = 3; // 半径3マスの球体状領域

        replaceBlocksInSphere(world, pos, radius);
    }

    private static void replaceBlocksInSphere(Level world, BlockPos center, int radius) {

        if (diamondflag == true) {
            for (int x = -radius; x <= radius; x++) {
                for (int y = -radius; y <= radius; y++) {
                    for (int z = -radius; z <= radius; z++) {
                        BlockPos targetPos = center.offset(x, y, z);
                        double distanceSq = center.distSqr(targetPos);

                        // 半径3マス以内のブロックかどうかをチェック
                        if (distanceSq <= radius * radius) {
                            BlockState targetState = world.getBlockState(targetPos);

                            // 空気ブロックでない場合にのみ置換
                            if (!targetState.isAir()) {
                                world.setBlock(targetPos, Blocks.DIAMOND_BLOCK.defaultBlockState(), 3);
                            }
                        }
                    }
                }
            }
        }
    }


    public static void register() {
        MinecraftForge.EVENT_BUS.register(ReplaceDiamond.class);
    }

}
