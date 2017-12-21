package com.smoroa14_kevox.slendermod.entity;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.smoroa14_kevox.slendermod.proxy.CommonProxy;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;

public class Slender extends EntityEnderman {

    public Slender(World worldIn) {
        super(worldIn);
        this.setSize(0.6F, 2.9F);
        this.stepHeight = 1.0F;
        this.setPathPriority(PathNodeType.WATER, -1.0F);
    }

    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D, 0.0F));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 10, true, false, new Predicate<EntityPlayer>() {
            public boolean apply(@Nullable EntityPlayer p_apply_1_) {
                return p_apply_1_.isPlayerFullyAsleep();
            }
        }));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(128.0D);


    }

    protected void updateAITasks() {
        if (this.isWet()) {
            this.attackEntityFrom(DamageSource.DROWN, 1.0F);

        }


        float f = this.getBrightness();

        if (f > 0.5F && this.world.canSeeSky(new BlockPos(this)) && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
            this.setAttackTarget((EntityLivingBase) null);
            this.teleportRandomly();
        }


        super.updateAITasks();
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable(source)) {
            return false;
        } else if (source instanceof EntityDamageSourceIndirect) {
            for (int i = 0; i < 64; ++i) {
                if (this.teleportRandomly()) {
                    return true;
                }
            }

            return false;
        } else {
            boolean flag = super.attackEntityFrom(source, amount);

            if (source.isUnblockable() && this.rand.nextInt(10) != 0) {
                this.teleportRandomly();
            }

            return flag;
        }
    }

    /**
     * Teleport the slenderman to a random nearby position
     */
    protected boolean teleportRandomly() {
        System.out.println("-------------------------------------------------------------------------------------------------------- ttr");
        double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 20.0D;
        double d1 = this.posY + (double) (this.rand.nextInt(20) - 10);
        double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 20.0D;
        return this.teleportTo(d0, d1, d2);
    }

    protected boolean teleportToEntity(Entity p_70816_1_) {
        Vec3d vec3d = new Vec3d(this.posX - p_70816_1_.posX, this.getEntityBoundingBox().minY + (double) (this.height / 2.0F) - p_70816_1_.posY + (double) p_70816_1_.getEyeHeight(), this.posZ - p_70816_1_.posZ);
        vec3d = vec3d.normalize();
        double d0 = 16.0D;
        double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3d.x * 16.0D;
        double d2 = this.posY + (double) (this.rand.nextInt(16) - 8) - vec3d.y * 16.0D;
        double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3d.z * 16.0D;
        return this.teleportTo(d1, d2, d3);
    }


    /*protected boolean teleportToEntity(Entity p_70816_1_) {

        System.out.println("----------------------------------------------------------------------------------------------------------- tte");

        /*Vec3d vec3d = new Vec3d(entity.posX, entity.posY, entity.posZ);
        vec3d = vec3d.normalize();

        double d1 = vec3d.x;
        double d2 = vec3d.y;
        double d3 = vec3d.z;

        float rotation = entity.getRotationYawHead() % 360;

        if (rotation < 0) {
            rotation = 360 - rotation;
        }

        if (rotation >= 225 && rotation <= 315) d1 += 2;
        if (rotation <= 135 && rotation <= 45) d1 -= 2;
        if (rotation >= 135 && rotation <= 225) d3 += 2;
        if (rotation <= 45 && rotation >= 315) d3 += 2;

        boolean ret = this.teleportTo(d1, d2, d3);

        //this.playSound();

        return ret;

        Vec3d vec3d = new Vec3d(this.posX - p_70816_1_.posX, this.getEntityBoundingBox().minY + (double) (this.height / 2.0F) - p_70816_1_.posY + (double) p_70816_1_.getEyeHeight(), this.posZ - p_70816_1_.posZ);
        vec3d = vec3d.normalize();
        double d0 = 16.0D;
        double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3d.x * 16.0D;
        double d2 = this.posY + (double) (this.rand.nextInt(16) - 8) - vec3d.y * 16.0D;
        double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3d.z * 16.0D;
        return this.teleportTo(d1, d2, d3);
    }
*/

    private boolean teleportTo(double x, double y, double z) {
        System.out.println("------------------------------------------------------------------------------------------ tt");
        net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(this, x, y, z, 0);
        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return false;
        boolean flag = this.attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ());

        if (flag) {
            this.world.playSound((EntityPlayer) null, this.prevPosX, this.prevPosY, this.prevPosZ, SoundEvents.ENTITY_ENDERMEN_TELEPORT, this.getSoundCategory(), 1.0F, 1.0F);
            this.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
        }


        return flag;
    }

    private boolean shouldAttackPlayer(EntityPlayer player) {
        System.out.println("should");
        ItemStack itemstack = player.inventory.armorInventory.get(3);


        if (itemstack.getItem() == Item.getItemFromBlock(Blocks.PUMPKIN)) {
            return false;
        } else {
            Vec3d vec3d = player.getLook(1.0F).normalize();
            Vec3d vec3d1 = new Vec3d(this.posX - player.posX, this.getEntityBoundingBox().minY + (double) this.getEyeHeight() - (player.posY + (double) player.getEyeHeight()), this.posZ - player.posZ);
            double d0 = vec3d1.lengthVector();
            vec3d1 = vec3d1.normalize();
            double d1 = vec3d.dotProduct(vec3d1);
            return d1 > 1.0D - 0.025D / d0 ? player.canEntityBeSeen(this) : false;
        }
    }

    public boolean canAttackClass(Class par1Class) {
        return EntityCreeper.class != par1Class && EntityGhast.class != par1Class;
    }

    static class AIFindPlayer extends EntityAINearestAttackableTarget<EntityPlayer> {
        private final Slender slenderman;
        /**
         * The player
         */
        private EntityPlayer player;
        private int aggroTime;
        private int teleportTime;

        public AIFindPlayer(Slender p_i45842_1_) {
            super(p_i45842_1_, EntityPlayer.class, false);
            this.slenderman = p_i45842_1_;
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute() {
            double d0 = this.getTargetDistance();
            this.player = this.slenderman.world.getNearestAttackablePlayer(this.slenderman.posX, this.slenderman.posY, this.slenderman.posZ, d0, d0, (Function) null, new Predicate<EntityPlayer>() {
                public boolean apply(@Nullable EntityPlayer p_apply_1_) {
                    return p_apply_1_ != null && Slender.AIFindPlayer.this.slenderman.shouldAttackPlayer(p_apply_1_);
                }
            });
            return this.player != null;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            this.aggroTime = 5;
            this.teleportTime = 0;
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {
            this.player = null;
            super.resetTask();
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            if (this.player != null) {
                if (!this.slenderman.shouldAttackPlayer(this.player)) {
                    return false;
                } else {
                    this.slenderman.faceEntity(this.player, 10.0F, 10.0F);
                    return true;
                }
            } else {
                return this.targetEntity != null && ((EntityPlayer) this.targetEntity).isEntityAlive() ? true : super.shouldContinueExecuting();
            }
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask() {
            if (this.player != null) {
                if (--this.aggroTime <= 0) {
                    this.targetEntity = this.player;
                    this.player = null;
                    super.startExecuting();
                }
            } else {
                if (this.targetEntity != null) {
                    if (this.slenderman.shouldAttackPlayer((EntityPlayer) this.targetEntity)) {
                        if (((EntityPlayer) this.targetEntity).getDistanceSqToEntity(this.slenderman) < 16.0D) {
                            this.slenderman.teleportRandomly();
                        }

                        this.teleportTime = 0;
                    } else if (((EntityPlayer) this.targetEntity).getDistanceSqToEntity(this.slenderman) > 256.0D && this.teleportTime++ >= 30 && this.slenderman.teleportToEntity(this.targetEntity)) {
                        this.teleportTime = 0;
                    }
                }

                super.updateTask();
            }
        }
    }

    public void onLivingUpdate() {
        if (this.world.isDaytime() && !this.world.isRemote && !this.isChild() && this.shouldBurnInDay()) {
            float f = this.getBrightness();

            if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.world.canSeeSky(new BlockPos(this.posX, this.posY + (double) this.getEyeHeight(), this.posZ))) {
                boolean flag = true;
                ItemStack itemstack = this.getItemStackFromSlot(EntityEquipmentSlot.HEAD);

                if (!itemstack.isEmpty()) {
                    if (itemstack.isItemStackDamageable()) {
                        itemstack.setItemDamage(itemstack.getItemDamage() + this.rand.nextInt(2));

                        if (itemstack.getItemDamage() >= itemstack.getMaxDamage()) {
                            this.renderBrokenItemStack(itemstack);
                            this.setItemStackToSlot(EntityEquipmentSlot.HEAD, ItemStack.EMPTY);
                        }
                    }

                    flag = false;
                }

                if (flag) {
                    this.setFire(8);
                }
            }
        }

        super.onLivingUpdate();
    }

    protected boolean shouldBurnInDay() {
        return true;
    }


    @Override
    public void onUpdate() {

        List<EntityPlayer> players = this.world.playerEntities;

        for (EntityPlayer player :
                players) {
            double x = player.posX - this.posX;
            double y = player.posY - this.posY;
            double z = player.posZ - this.posZ;
            x = x < 0 ? x * (-1) : x;
            y = y < 0 ? y * (-1) : y;
            z = z < 0 ? z * (-1) : z;
            boolean light = false;
            ItemStack item = player.getHeldItemMainhand();
            ItemStack itemOff = player.getHeldItemOffhand();
            if (item.getUnlocalizedName().equalsIgnoreCase(Blocks.TORCH.getUnlocalizedName())
                    || itemOff.getUnlocalizedName().equalsIgnoreCase(Blocks.TORCH.getUnlocalizedName())) {
                light = true;
            }

            if (x < 15 && y < 15 && z < 15) player.addPotionEffect(new PotionEffect(Potion.getPotionById(15), 17, 155));
            if (x < 12 && y < 12 && z < 12 && !light)
                player.addPotionEffect(new PotionEffect(Potion.getPotionById(15), 18, 155));
            if (x < 9 && y < 9 && z < 9 && !light)
                player.addPotionEffect(new PotionEffect(Potion.getPotionById(15), 19, 155));
        }

        super.onUpdate();
    }
}