package com.smoroa14_kevox.slendermod.renderer;

import com.smoroa14_kevox.slendermod.SlenderMod;
import com.smoroa14_kevox.slendermod.entity.Slender;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerEndermanEyes;
import net.minecraft.client.renderer.entity.layers.LayerHeldBlock;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

@SideOnly(Side.CLIENT)
public class RenderSlender extends RenderBiped<Slender>
{
    private static final ResourceLocation ENDERMAN_TEXTURES = new ResourceLocation("slendermod:textures/entities/slender.png");
    private final Random rnd = new Random();

    public RenderSlender(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelSlender(0.0F), 0.5F);

    }

    public ModelSlender getMainModel()
    {
        return (ModelSlender)super.getMainModel();
    }

    /**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(Slender entity, double x, double y, double z, float entityYaw, float partialTicks)
    {

        ModelSlender modelenderman = this.getMainModel();





        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Slender entity)
    {
        return ENDERMAN_TEXTURES;
    }
}