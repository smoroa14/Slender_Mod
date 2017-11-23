package com.smoroa14_kevox.slendermod.renderer;

import com.smoroa14_kevox.slendermod.SlenderMod;
import com.smoroa14_kevox.slendermod.entity.Slender;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSlender extends RenderBiped<Slender>
{
    private static final ResourceLocation ZOMBIE_TEXTURES = new ResourceLocation(SlenderMod.MODID,"textures/entities/slender.png");
 public static ModelSlender model = new ModelSlender();

    public RenderSlender(RenderManager renderManagerIn)
    {
        super(renderManagerIn, model, 0.5F);
    }

    /**
     * Returns the location of an entities's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Slender entity)
    {
        return ZOMBIE_TEXTURES;
        }
        }