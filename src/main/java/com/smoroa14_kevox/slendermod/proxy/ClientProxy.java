package com.smoroa14_kevox.slendermod.proxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        /*GameRegistry.addShapedRecipe(new ResourceLocation("Virus Essence"), null, new ItemStack(CommonProxy.VIRUS_ESSENCE),
                "XXX",
                "XOX",
                "XXX",
                'X', Items.SLIME_BALL,
                'O', Items.NETHER_STAR);*/
    }
}
