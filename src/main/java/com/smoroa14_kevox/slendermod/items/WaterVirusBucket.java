package virusmod.items;

import com.smoroa14_kevox.slendermod.engine.PlaceWater;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBucket;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WaterVirusBucket extends ItemBucket {
    public WaterVirusBucket(Block containedBlockIn, String name) {
        super(containedBlockIn);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(pos != null)
        {
            Thread t = new Thread(new PlaceWater(worldIn, pos.getX(), pos.getY(), pos.getZ()));
            t.start();
        }
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }
}
