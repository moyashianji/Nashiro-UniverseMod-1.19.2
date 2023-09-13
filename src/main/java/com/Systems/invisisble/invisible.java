package com.Systems.invisisble;

import com.Systems.ReplaceDiamond;
import com.google.common.eventbus.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class invisible {



    @SubscribeEvent
    public void setup(ViewportEvent event){
        System.out.println("invisible");
        Entity player = Minecraft.getInstance().player;
        if(player != null && event.getPartialTick() == 1.0F){
            player.setInvisible(true);
        }
    }
    public static void register() {
        MinecraftForge.EVENT_BUS.register(invisible.class);
    }

}

