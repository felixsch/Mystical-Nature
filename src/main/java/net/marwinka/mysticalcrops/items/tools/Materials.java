package net.marwinka.mysticalcrops.items.tools;

import net.marwinka.mysticalcrops.registry.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum Materials implements ToolMaterial {
    COMMON(1, 100, 1.0f, 2.0f, false),
    UNCOMMON(2, 400, 2.0f, 3.0f, false),
    WONDERFUL(3, 800, 3.0f, 4.0f, false),
    EXCELLENT(4, 1500, 4.0f, 5.0f, false),
    PERFECT(4, 3000, 5.0f, 6.0f, false),
    INFINITY(4, 9999, 6.0f, 8.0f, true);

    private int level;
    private int durability;
    private float speed;
    private float damage;
    private boolean infinite;

    private Materials(int level, int durability, float speed, float damage, boolean infinite) {
      this.level = level;
      this.durability = durability;
      this.speed = speed;
      this.damage = damage;
      this.infinite = infinite;
    }

    public float getAttackDamage() { return this.damage; }
    public int getDurability() { return this.durability; }
    public int getMiningLevel() { return this.level; }
    public float getMiningSpeedMultiplier() { return this.speed; }

    public boolean isInfinite() { return this.infinite; }

    public int getEnchantability() { return 0; }
    public Ingredient getRepairIngredient() { return Ingredient.empty(); }
}
