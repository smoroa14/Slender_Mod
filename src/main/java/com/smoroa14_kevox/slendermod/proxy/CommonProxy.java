package com.smoroa14_kevox.slendermod.proxy;

import com.smoroa14_kevox.slendermod.SlenderMod;
import com.smoroa14_kevox.slendermod.entity.Slender;
import com.smoroa14_kevox.slendermod.items.*;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.TreeSet;

@Mod.EventBusSubscriber(modid = SlenderMod.MODID)
public class CommonProxy {
    //public static Block FLINT_STONE_BLOCK = new FlintstoneBlock("fredblock");
    public static Item BATTERIE = new Batterie("batterie");
    public static Item REMOTE = new GameStarter("remote");
    public static ItemTool LATERNE = new Laterne(Item.ToolMaterial.IRON, new TreeSet<>(), "laterne");
    public static ItemWritableBook ZETTEL = new Zettel("zettel");
    public static ItemSword ENDERSWORD = new EnderSword(Item.ToolMaterial.DIAMOND,"endersword");


    public void init(FMLInitializationEvent event){
        //EntityRegistry.registerModEntity(new ModelResourceLocation("slender","inventory"),Slender.class,"slender",1,this,80,3,true);
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
        event.getRegistry().register(REMOTE);
        event.getRegistry().register(ENDERSWORD);
    }

    @SubscribeEvent
    public static void registerRenderers(ModelRegistryEvent event)
    {
        //registerRenderer(Item.getItemFromBlock(FLINT_STONE_BLOCK));
        registerRenderer(BATTERIE);
        registerRenderer(ZETTEL);
        registerRenderer(LATERNE);
        registerRenderer(REMOTE);
       registerRenderer(ENDERSWORD);
    }

    @SubscribeEvent
    public static void renderEntities(RegistryEvent.Register<EntityEntry> event)
    {
        ResourceLocation location = new ResourceLocation(SlenderMod.MODID, "entities/slender.png");
        EntityRegistry.registerModEntity(location, Slender.class, "slender",0,SlenderMod.instance,64,1,true,0xffffff,0x000000);
    }

    private static void registerRenderer(Item item)
    {
        //ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
    }



}
