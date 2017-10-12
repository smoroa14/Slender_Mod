package com.smoroa14_kevox.slendermod.items;

import javafx.scene.LightBase;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import java.util.Set;


public class Laterne extends ItemTool{

    public boolean activated = false;

    public Laterne(ToolMaterial materialIn, Set<Block> effectiveBlocksIn, String name) {
        super(materialIn, effectiveBlocksIn);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if(!activated)
        {
            activated = true;
            System.out.println(activated);


        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
