package com.smoroa14_kevox.slendermod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemDye;


public class Taschenlampe extends ItemDye{
    public Taschenlampe(String name)
    {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.MISC);
    }


}
