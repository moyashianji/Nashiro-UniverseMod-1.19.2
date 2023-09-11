package com.Systems.invisisble;

import com.Systems.ReplaceDiamond;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.w3c.dom.Entity;

public class invisible {
    @SubscribeEvent
    public void onRenderPlayer(RenderLivingEvent.Pre event){
        System.out.println("t");

            System.out.println("sss");
            event.setCanceled(true);

    }
    public static void register() {
        MinecraftForge.EVENT_BUS.register(invisible.class);
    }

}

