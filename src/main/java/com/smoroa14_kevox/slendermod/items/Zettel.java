package com.smoroa14_kevox.slendermod.items;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import java.awt.image.WritableRaster;

public class Zettel extends ItemWritableBook{
    public Zettel(String name) {
        super();
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        Minecraft m = Minecraft.getMinecraft();
        m.displayGuiScreen(new GuiScreenBook(playerIn, playerIn.getHeldItem(handIn), true));
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
