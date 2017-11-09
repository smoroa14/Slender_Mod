package com.smoroa14_kevox.slendermod.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.item.ItemWrittenBook;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Notiz extends ItemWrittenBook{
    public Notiz(String name) {
        super();
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.MISC);
    this.isDamageable();
    this.isRepairable();
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        Minecraft m = Minecraft.getMinecraft();
        m.displayGuiScreen(new GuiScreenBook(playerIn, playerIn.getHeldItem(handIn), true));
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
