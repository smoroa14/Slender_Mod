package com.smoroa14_kevox.slendermod.items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Zettel extends ItemBook{
    public Zettel(String name) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

    return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
