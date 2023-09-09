package net.marwinka.mysticalcrops.items.tools;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.block.BlockState;

import net.marwinka.mysticalcrops.items.tools.Materials;
import static net.marwinka.mysticalcrops.MysticalCrops.ITEMGROUPCLASSIC;

public class Crystal extends ToolItem {
    private boolean isInfinite;

    public Crystal(Materials material) {
        super(material, new FabricItemSettings().group(ITEMGROUPCLASSIC).maxCount(1));
        this.isInfinite = material.isInfinite();
    }

    @Override
    public boolean isDamageable() {
        return !this.isInfinite;
    }

    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
      return this.getMaterial().getMiningSpeedMultiplier();
    }
}
