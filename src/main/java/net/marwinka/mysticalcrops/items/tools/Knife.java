package net.marwinka.mysticalcrops.items.tools;

import java.lang.Math;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.block.BlockState;

import net.marwinka.mysticalcrops.items.tools.Materials;
import static net.marwinka.mysticalcrops.MysticalCrops.ITEMGROUPCLASSIC;

public class Knife extends SwordItem {
    private boolean isInfinite;

    public Knife(Materials material) {
        super(material, 0, 0, new FabricItemSettings().group(ITEMGROUPCLASSIC).maxCount(1));
        this.isInfinite = material.isInfinite();
    }

    @Override
    public boolean isDamageable() {
        return this.isInfinite;
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
      return this.getMaterial().getMiningSpeedMultiplier();
    }
}
