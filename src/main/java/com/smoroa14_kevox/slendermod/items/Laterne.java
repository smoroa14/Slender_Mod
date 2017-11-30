package com.smoroa14_kevox.slendermod.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemTool;

import java.util.Set;


public class Laterne extends ItemTool {

    public boolean activated = false;
    public EntityPlayer p = null;

    public Laterne(ToolMaterial materialIn, Set<Block> effectiveBlocksIn, String name) {
        super(materialIn, effectiveBlocksIn);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.MISC);
    }
/*
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        p = playerIn;
        if(!activated)
        {
            enableLight();
        }else{
            disableLight();
        }
        System.out.println(activated);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    public void onTick()
    {
        if(!activated)
        {
            enableLight();
        }else{
            disableLight();
        }
    }

    private void enableLight()
    {
        activated = true;
        DynamicLights.removeLightSource(this);
        DynamicLights.addLightSource(this);
    }

    private void disableLight()
    {
        activated = false;
        DynamicLights.removeLightSource(this);
    }

    @Override
    public Entity getAttachmentEntity() {
        return p;
    }

    @Override
    public int getLightLevel() {
        return 30;
    }
    */
}


