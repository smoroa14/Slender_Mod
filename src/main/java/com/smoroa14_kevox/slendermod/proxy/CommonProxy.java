package com.smoroa14_kevox.slendermod.proxy;

import com.smoroa14_kevox.slendermod.SlenderMod;
import com.smoroa14_kevox.slendermod.entity.Slender;
import com.smoroa14_kevox.slendermod.items.Batterie;
import com.smoroa14_kevox.slendermod.items.Laterne;

import com.smoroa14_kevox.slendermod.items.Zettel;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemTool;
import net.minecraft.item.ItemWritableBook;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.TreeSet;

@Mod.EventBusSubscriber(modid = SlenderMod.MODID)
public class CommonProxy {
    //public static Block FLINT_STONE_BLOCK = new FlintstoneBlock("fredblock");
    public static Item BATTERIE = new Batterie("batterie");
    public static ItemTool LATERNE = new Laterne(Item.ToolMaterial.IRON, new TreeSet<>(), "laterne");
public static ItemWritableBook ZETTEL = new Zettel("zettel");


    public void init(FMLInitializationEvent event){
        EntityRegistry.registerModEntity(new ModelResourceLocation("slender","inventory"),Slender.class,"slender",1,this,80,3,true);
    }
    public void preInit(FMLPreInitializationEvent event){
    }
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
        event.getRegistry().register(LATERNE);
        event.getRegistry().register(ZETTEL);
    }

    @SubscribeEvent
    public static void registerRenderers(ModelRegistryEvent event)
    {
        //registerRenderer(Item.getItemFromBlock(FLINT_STONE_BLOCK));
        registerRenderer(BATTERIE);
        registerRenderer(ZETTEL);
        registerRenderer(LATERNE);
    }

    private static void registerRenderer(Item item)
    {
        //ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
    }

    @SubscribeEvent
    public static void registerSpawnEntity(Class entityClass, String name, int id, int primaryCOlor, int secondaryColor, boolean addSpawn, EnumCreatureType typeOfCreature)
    {
        //registerRenderer(Item.getItemFromBlock(FLINT_STONE_BLOCK));

    }

}
