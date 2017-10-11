package com.smoroa14_kevox.slendermod.proxy;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        /*GameRegistry.addShapelessRecipe(new ResourceLocation("Virus Essence"), null, new ItemStack(CommonProxy.TASCHENLAMPE),
                new Ingredient(new ItemStack(CommonProxy.TASCHENLAMPE)), new Ingredient(new ItemStack(CommonProxy.BATTERIE));*/
    }
}
