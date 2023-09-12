package com.Systems.guns.tab;


import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class GunsTab{

    public static CreativeModeTab GUN_TAB;
    public static void load(){
        GUN_TAB = new CreativeModeTab("gun_tab"){
            @Override
            public ItemStack makeIcon(){
                return new ItemStack(Items.TNT);
            }
            @Override
            public boolean hasSearchBar(){
                return false;
            }
        };
    }
}