package virusmod.blocks;


import com.smoroa14_kevox.slendermod.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class IceVirusBlock extends Block{
    public IceVirusBlock(String name)
    {
        super(Material.ICE);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        //Configuration block
        setHardness(2.f);
        setResistance(4.f);
        setSoundType(SoundType.GLASS);
    }


    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        System.out.println("update!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }


    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
        Block b = world.getBlockState(new BlockPos(x+1, y, z)).getBlock();
        if(b != Blocks.AIR && b != CommonProxy.ICE_VIRUS_BLOCK)
        {
            world.setBlockState(new BlockPos(x+1, y, z), world.getBlockState(new BlockPos(x, y, z)));
        }
        b = world.getBlockState(new BlockPos(x-1, y, z)).getBlock();
        if(b != Blocks.AIR && b != CommonProxy.ICE_VIRUS_BLOCK)
        {
            world.setBlockState(new BlockPos(x-1, y, z), world.getBlockState(new BlockPos(x, y, z)));
        }
        b = world.getBlockState(new BlockPos(x, y, z+1)).getBlock();
        if(b != Blocks.AIR && b != CommonProxy.ICE_VIRUS_BLOCK)
        {
            world.setBlockState(new BlockPos(x, y, z+1), world.getBlockState(new BlockPos(x, y, z)));
        }
        b = world.getBlockState(new BlockPos(x, y, z-1)).getBlock();
        if(b != Blocks.AIR && b != CommonProxy.ICE_VIRUS_BLOCK)
        {
            world.setBlockState(new BlockPos(x+1, y, z-1), world.getBlockState(new BlockPos(x, y, z)));
        }
    }

}
