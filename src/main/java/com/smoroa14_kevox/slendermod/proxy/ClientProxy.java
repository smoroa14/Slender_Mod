package virusmod.proxy;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
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
        GameRegistry.addShapedRecipe(new ResourceLocation("Virus Essence"), null, new ItemStack(CommonProxy.VIRUS_ESSENCE),
                "XXX",
                "XOX",
                "XXX",
                'X', Items.SLIME_BALL,
                'O', Items.NETHER_STAR);

        GameRegistry.addShapedRecipe(new ResourceLocation("Water Virus"), null, new ItemStack(Items.WATER_BUCKET),
                "OOO",
                "XVX",
                "XXX",
                'X', Blocks.LAPIS_ORE,
                'O', Items.WATER_BUCKET,
                'V', CommonProxy.VIRUS_ESSENCE);

        GameRegistry.addShapedRecipe(new ResourceLocation("Grass Virus"), null, new ItemStack(CommonProxy.GRASS_VIRUS_BLOCK),
                "OOO",
                "XVX",
                "XXX",
                'X', Blocks.LEAVES,
                'O',Items.WHEAT_SEEDS,
                'V', CommonProxy.VIRUS_ESSENCE);

        GameRegistry.addShapedRecipe(new ResourceLocation("Lava Virus"), null, new ItemStack(Items.LAVA_BUCKET),
                "OOO",
                "XVX",
                "XXX",
                'X', Items.MAGMA_CREAM,
                'O', Items.LAVA_BUCKET,
                'V', CommonProxy.VIRUS_ESSENCE);
    }
}
