package com.smoroa14_kevox.slendermod.proxy;

import com.smoroa14_kevox.slendermod.SlenderMod;
import com.smoroa14_kevox.slendermod.items.Batterie;
import com.smoroa14_kevox.slendermod.items.Taschenlampe;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.TreeSet;

@Mod.EventBusSubscriber(modid = SlenderMod.MODID)
public class CommonProxy {
    //public static Block FLINT_STONE_BLOCK = new FlintstoneBlock("fredblock");
    public static Item BATTERIE = new Batterie("batterie");
    public static ItemTool TASCHENLAMPE = new Taschenlampe(Item.ToolMaterial.IRON, new TreeSet<>(), "taschenlampe");


    public void init(FMLInitializationEvent event){}
    public void preInit(FMLPreInitializationEvent event){}
    public void postInit(FMLPostInitializationEvent event){}

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        //event.getRegistry().register(FLINT_STONE_BLOCK);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        //event.getRegistry().register(new ItemBlock(FLINT_STONE_BLOCK).setRegistryName(FLINT_STONE_BLOCK.getRegistryName()));
        event.getRegistry().register(BATTERIE);
        event.getRegistry().register(TASCHENLAMPE);
    }

    @SubscribeEvent
    public static void registerRenderers(ModelRegistryEvent event)
    {
        //registerRenderer(Item.getItemFromBlock(FLINT_STONE_BLOCK));
        registerRenderer(BATTERIE);
        registerRenderer(TASCHENLAMPE);
    }

    private static void registerRenderer(Item item)
    {
        //ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
    }


}
