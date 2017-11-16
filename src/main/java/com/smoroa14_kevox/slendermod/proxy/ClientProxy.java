package com.smoroa14_kevox.slendermod.proxy;

import com.smoroa14_kevox.slendermod.entity.Slender;
import com.smoroa14_kevox.slendermod.renderer.RenderSlender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(Slender.class, new RenderSlender(Minecraft.getMinecraft().getRenderManager()) {
        });

    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);


    }
}
