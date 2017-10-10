package virusmod.engine;

import com.smoroa14_kevox.slendermod.proxy.CommonProxy;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PlaceWater implements Runnable {

    private World world;
    private int x;
    private int y;
    private int z;
    private int count = 1;

    public PlaceWater(World world, int x, int y, int z) {

        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public PlaceWater(World world, int x, int y, int z, int count) {

        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.count = count;
    }

    @Override
    public void run() {
        if(count > 100) {
            Thread[] ts = new Thread[4];
            IBlockState bs = world.getBlockState(new BlockPos(x + 1, y, z));
            threads(bs, x + 1, y, z, ts, 0, count);

            bs = world.getBlockState(new BlockPos(x - 1, y, z));
            threads(bs, x - 1, y, z, ts, 1, count);

            bs = world.getBlockState(new BlockPos(x, y, z + 1));
            threads(bs, x, y, z + 1, ts, 2, count);

            bs = world.getBlockState(new BlockPos(x, y, z - 1));
            threads(bs, x, y, z - 1, ts, 3, count);
        }
    }

    public void threads(IBlockState bs, int x, int y, int z, Thread[] ts, int pos, int count)
    {
        bs = world.getBlockState(new BlockPos(x, y, z));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(bs.getBlock() == Blocks.AIR)
        {
            world.setBlockState(new BlockPos(x, y, z), CommonProxy.GRASS_VIRUS_BLOCK.getDefaultState());
            Thread t = new Thread(new PlaceWater(world, x, y, z, ++this.count));
            ts[pos] = t;
            ts[pos].start();
                /*CommonProxy.WATER_VIRUS_BUCKET.notify();
                try {
                    CommonProxy.WATER_VIRUS_BUCKET.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
        }
    }
}
