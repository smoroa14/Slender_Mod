package com.smoroa14_kevox.slendermod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class GameStarter extends Item implements Runnable{

    public static boolean gameStarted = false;
    private Thread gameThread;
    private World currentWorld;
    private EntityPlayer currentPlayer;

    public GameStarter(String name) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.MISC);
        this.setMaxStackSize(6);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if(!gameStarted)
        {
            gameStarted = true;
            gameThread = new Thread(this);
            currentWorld = worldIn;
            currentPlayer = playerIn;
            gameThread.start();
        }else{
            gameStarted = false;
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public void run() {
        while (true)
        {
            //currentPlayer.addPotionEffect(new PotionEffect(Potion.getPotionById(15), 10000, 1));
            //EntityRegistry.registerModEntity(new ResourceLocation("EntityPlayer"), EntityPlayer.class, "EntityPlayer", 1, this, 30, 1, true);
            try {
                System.out.println(currentPlayer.getRotationYawHead());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!gameStarted)
            {
                break;
            }
        }
    }
}
