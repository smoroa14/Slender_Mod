package com.smoroa14_kevox.slendermod.items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class EnderSword extends ItemSword{
    public EnderSword(ToolMaterial material, String name) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
this.isRepairable();

    }

    @Override
    public boolean canHarvestBlock(IBlockState blockIn) {
        return blockIn.getBlock().getHarvestLevel(blockIn) < 0;
    }
}
