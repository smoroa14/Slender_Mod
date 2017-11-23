package com.smoroa14_kevox.slendermod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GameStarter extends Item {
    public GameStarter(String name) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.MISC);
        this.setMaxStackSize(6);
    }
}
