package com.smoroa14_kevox.slendermod.entity;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Slender extends EntityMob
{

    public Slender(World worldIn) {
        super(worldIn);
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D, 0.0F));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 10, true, false, new Predicate<EntityPlayer>()
        {
            public boolean apply(@Nullable EntityPlayer p_apply_1_)
            {
                return p_apply_1_.isPlayerFullyAsleep();
            }
        }));
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(64.0D);
    }

    protected void updateAITasks()
    {
        if (this.isWet())
        {
            this.attackEntityFrom(DamageSource.DROWN, 1.0F);
        }


            float f = this.getBrightness();

            if (f > 0.5F && this.world.canSeeSky(new BlockPos(this)) && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F)
            {
                this.setAttackTarget((EntityLivingBase)null);
                this.teleportRandomly();
            }


        super.updateAITasks();
    }



    /**
     * Teleport the enderman to a random nearby position
     */
    protected boolean teleportRandomly()
    {
        return false;
        /*double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 20.0D;
        double d1 = this.posY + (double)(this.rand.nextInt(20) - 10);
        double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 20.0D;
        return this.teleportTo(d0, d1, d2);*/
    }

    protected boolean teleportToEntity(Entity entity)
    {
        Vec3d vec3d = new Vec3d(entity.posX,  entity.posY, entity.posZ);
        vec3d = vec3d.normalize();

        double d1 = vec3d.x;
        double d2 = vec3d.y;
        double d3 = vec3d.z;

        float rotation = entity.getRotationYawHead() % 360;

        if(rotation < 0)
        {
            rotation = 360 - rotation;
        }

        if(rotation >= 225 && rotation <= 315) d1+=2;
        if(rotation <= 135 && rotation <= 45) d1-=2;
        if(rotation >= 135 && rotation <= 225) d3+=2;
        if(rotation <= 45 && rotation >= 315) d3+=2;

        boolean ret = this.teleportTo(d1, d2, d3);

        //this.playSound();

        return ret;
    }

    /**
     * Teleport the enderman
     */
    private boolean shouldAttackPlayer(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.armorInventory.get(3);

        if (itemstack.getItem() == Item.getItemFromBlock(Blocks.PUMPKIN))
        {
            return false;
        }
        else
        {
            Vec3d vec3d = player.getLook(1.0F).normalize();
            Vec3d vec3d1 = new Vec3d(this.posX - player.posX, this.getEntityBoundingBox().minY + (double)this.getEyeHeight() - (player.posY + (double)player.getEyeHeight()), this.posZ - player.posZ);
            double d0 = vec3d1.lengthVector();
            vec3d1 = vec3d1.normalize();
            double d1 = vec3d.dotProduct(vec3d1);
            return d1 > 1.0D - 0.025D / d0 ? player.canEntityBeSeen(this) : false;
        }
    }


    private boolean teleportTo(double x, double y, double z)
    {
        net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(this, x, y, z, 0);
        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return false;
        boolean flag = this.attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ());

        if (flag)
        {
            this.world.playSound((EntityPlayer)null, this.prevPosX, this.prevPosY, this.prevPosZ, SoundEvents.ENTITY_ENDERMEN_TELEPORT, this.getSoundCategory(), 1.0F, 1.0F);
            this.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
        }


        return flag;
    }



    public boolean canAttackClass(Class par1Class)
    {
        return EntityCreeper.class != par1Class && EntityGhast.class != par1Class;
    }
}