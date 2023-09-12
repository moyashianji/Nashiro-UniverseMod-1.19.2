package com.Systems.guns.init;

import com.Systems.guns.item.TntGun;
import com.main.reference;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GunItems {

    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, reference.MOD_ID);
    public static final RegistryObject<Item> TNT_GUNS = REGISTRY.register("tnt_guns", () -> new TntGun());

 }
