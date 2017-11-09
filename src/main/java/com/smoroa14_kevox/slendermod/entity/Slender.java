package com.smoroa14_kevox.slendermod.entity;

import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class Slender extends EntityEnderman {

    public Slender(World worldIn) {
        super(worldIn);
        setSize(1.5F, 1.9F);
    }

    protected String getLivingSound()
    {
        return null; // any sound your mob makes will be set here. Look in other Entity classes to see what code it uses.
    }

    protected String getHurtSound()
    {
        return null;
    }

    protected float getSoundVolume()
    {
        return 0.4F;
    }

    protected int getDropItemId()
    {
        return 0; // this is the drop item ID for your mob. For example, set this to "return 278;" to drop a diamond pickaxe upon dying.
    }

}
