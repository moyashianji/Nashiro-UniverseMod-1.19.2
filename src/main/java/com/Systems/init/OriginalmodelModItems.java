
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.Systems.init;

import com.main.reference;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;


public class OriginalmodelModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, reference.MOD_ID);
	public static final RegistryObject<Item> VILLEGER_SPAWN_EGG = REGISTRY.register("villeger_spawn_egg", () -> new ForgeSpawnEggItem(OriginalmodelModEntities.VILLEGER, -52429, -1, new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));
}
