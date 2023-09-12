package com.main;

import com.Systems.ReplaceDiamond;

import com.Systems.guns.init.GunItems;
import com.Systems.guns.tab.GunsTab;
import com.Systems.init.OriginalmodelModEntities;
import com.Systems.invisisble.invisible;
import com.command.Command;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(reference.MOD_ID)
public class nashiro {

    public nashiro() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        Command.register();
        ReplaceDiamond.register();
        OriginalmodelModEntities.REGISTRY.register(bus);
        invisible.register();
        GunItems.REGISTRY.register(bus);
        GunsTab.load();
        bus.addListener(this::onClientSetup);
    }


    private void setup(final FMLCommonSetupEvent event){

    }
    private void onClientSetup(FMLClientSetupEvent event){

    }
}
