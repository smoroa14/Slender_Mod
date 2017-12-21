package com.smoroa14_kevox.slendermod.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;


public class Laterne extends ItemTool {

    public boolean activated = false;
    public EntityPlayer p = null;
    public LocalDateTime lastTime = null;
    public boolean isSel = false;

    public Laterne(ToolMaterial materialIn, Set<Block> effectiveBlocksIn, String name) {
        super(materialIn, effectiveBlocksIn);
        this.setRegistryName(name);
        this.setMaxDamage(10);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(isSelected)
        {
            if(isSel)
            {
                int sec = LocalDateTime.now().getSecond() - lastTime.getSecond();
                if(sec > 10)
                {
                    this.setDamage(stack, 100);
                }
            }else
            {
                lastTime = LocalDateTime.now();
                isSel = true;
            }
        }else{
            isSel = false;
        }


        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
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


