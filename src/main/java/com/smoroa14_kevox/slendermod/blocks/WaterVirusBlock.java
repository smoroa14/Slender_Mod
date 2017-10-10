package virusmod.blocks;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class WaterVirusBlock extends Fluid{
    public WaterVirusBlock(String name) {
        super("infected_water", new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flow"));

    }




}
