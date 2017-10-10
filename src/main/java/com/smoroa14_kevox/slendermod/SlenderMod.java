package com.smoroa14_kevox.slendermod;

import com.smoroa14_kevox.slendermod.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SlenderMod.MODID, version = SlenderMod.VERSION)
public class SlenderMod
{
    public static final String MODID = "slendermod";
    public static final String VERSION = "1.0";

    @Mod.Instance
    public static SlenderMod instance;

    @SidedProxy(clientSide = "com.smoroa14_kevox.slendermod.proxy.ClientProxy",
            serverSide = "com.smoroa14_kevox.slendermod.proxy.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
     proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
