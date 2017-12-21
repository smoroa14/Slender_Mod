package com.smoroa14_kevox.slendermod.items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class EnderSword extends ItemSword{
    public EnderSword(ToolMaterial material, String name) {
        super(material);
        this.setRegistryName(name);
        this.setMaxDamage(10);
        this.setUnlocalizedName(name);
this.isRepairable();

    }

    @Override
    public boolean canHarvestBlock(IBlockState blockIn) {
        return blockIn.getBlock().getHarvestLevel(blockIn) < 0;
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(1, attacker);
        return true;
    }
}
