package com.smoroa14_kevox.slendermod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class EnderSword extends ItemSword{
    public EnderSword(ToolMaterial material, String name) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);

    }
}
