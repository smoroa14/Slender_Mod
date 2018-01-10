package com.smoroa14_kevox.slendermod.entity;

import com.smoroa14_kevox.slendermod.SlenderMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler
{
    public static final ResourceLocation SLENDER = LootTableList.register(new ResourceLocation(SlenderMod.MODID, "slender"));
}
