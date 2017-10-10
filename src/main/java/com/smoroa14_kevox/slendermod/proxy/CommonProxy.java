package virusmod.proxy;


import com.smoroa14_kevox.slendermod.VirusMod;
import com.smoroa14_kevox.slendermod.blocks.GrassVirusBlock;
import com.smoroa14_kevox.slendermod.blocks.IceVirusBlock;
import com.smoroa14_kevox.slendermod.blocks.WaterVirusBlock;
import com.smoroa14_kevox.slendermod.items.VirusEssence;
import com.smoroa14_kevox.slendermod.items.WaterVirusBucket;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = VirusMod.MODID)
public class CommonProxy {
    //public static Block FLINT_STONE_BLOCK = new FlintstoneBlock("fredblock");
    public static Block GRASS_VIRUS_BLOCK = new GrassVirusBlock("grassvirus");
    public static Block ICE_VIRUS_BLOCK = new IceVirusBlock("icevirus");
    public static Fluid WATER_VIRUS_FLUID = new WaterVirusBlock("watervirus");

    public static Item WATER_VIRUS_BUCKET = new WaterVirusBucket(Blocks.WATER, "watervirusbucket");
    public static Item VIRUS_ESSENCE = new VirusEssence("virusessence");

    public void init(FMLInitializationEvent event){}
    public void preInit(FMLPreInitializationEvent event){}
    public void postInit(FMLPostInitializationEvent event){}

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        //event.getRegistry().register(FLINT_STONE_BLOCK);
        event.getRegistry().register(GRASS_VIRUS_BLOCK);
        event.getRegistry().register(ICE_VIRUS_BLOCK);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        //event.getRegistry().register(new ItemBlock(FLINT_STONE_BLOCK).setRegistryName(FLINT_STONE_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(GRASS_VIRUS_BLOCK).setRegistryName(GRASS_VIRUS_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ICE_VIRUS_BLOCK).setRegistryName(ICE_VIRUS_BLOCK.getRegistryName()));
        event.getRegistry().register(VIRUS_ESSENCE);
        event.getRegistry().register(WATER_VIRUS_BUCKET);
    }

    @SubscribeEvent
    public static void registerRenderers(ModelRegistryEvent event)
    {
        //registerRenderer(Item.getItemFromBlock(FLINT_STONE_BLOCK));
        registerRenderer(Item.getItemFromBlock(ICE_VIRUS_BLOCK));
        registerRenderer(Item.getItemFromBlock(GRASS_VIRUS_BLOCK));
        registerRenderer(VIRUS_ESSENCE);
        registerRenderer(WATER_VIRUS_BUCKET);
    }

    private static void registerRenderer(Item item)
    {
        //ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
    }


}
