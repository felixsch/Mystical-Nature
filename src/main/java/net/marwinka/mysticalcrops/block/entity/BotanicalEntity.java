package net.marwinka.mysticalcrops.block.entity;

import net.marwinka.mysticalcrops.MysticalCrops;
import net.marwinka.mysticalcrops.recipe.BotanicalRecipe;
import net.marwinka.mysticalcrops.registry.ModBlockEntities;
import net.marwinka.mysticalcrops.registry.ModRecipes;
import net.marwinka.mysticalcrops.screenhandler.BotanicalHandler;
import net.marwinka.mysticalcrops.util.tags;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class BotanicalEntity extends AbstractTableEntity {
  public BotanicalEntity(BlockPos pos, BlockState state) {
    super(ModBlockEntities.BOTANICAL_TABLE, pos, state, 200);
  }

  @Nullable
  @Override
  public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
    return new BotanicalHandler(syncId, inv, this, this.propertyDelegate);
  }

  @Override
  public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
    Identifier id = Registry.ITEM.getId(stack.getItem());

    // NOTE: All fruits are dynamically created and therefore no predefined set exists
    // Hence matching by id is the easiest option until the registration is refactored
    boolean isFruit = id.getNamespace() == MysticalCrops.MOD_ID && id.getPath().endsWith("_fruit");
    boolean isKnive = stack.isIn(tags.KNIVES);

    if (!isFruit && !isKnive) {
      return false;
    }
    return super.canInsert(slot, stack, side);
  }

  @Override
  public boolean canExtract(int slot, ItemStack stack, Direction side) {
    return slot == 2;
  }


  public void tick() {
    if (this.world.isClient) {
      return;
    }

    SimpleInventory inventory = new SimpleInventory(this.size());
    for (int i = 0; i < this.size(); i++) {
      inventory.setStack(i, this.getStack(i));
    }

    RecipeManager manager = this.getWorld().getRecipeManager();
    Optional<BotanicalRecipe> maybeRecipe = manager.getFirstMatch(ModRecipes.BOTANICAL_RECIPE, inventory, this.getWorld());

    if (!maybeRecipe.isPresent()) {
      return;
    }
    BotanicalRecipe recipe = maybeRecipe.get();

    Item outputItem = recipe.getOutput().getItem();
    Item knife = this.getStack(0).getItem().asItem();

    if (canInsertAmountIntoOutputSlot(inventory) && canInsertItemIntoOutputSlot(inventory, outputItem)) {
      if (this.progress >= this.maxProgress) {
        int current = this.getStack(2).getCount();
        int additional = recipe.getOutput().getCount();

        this.getStack(1).decrement(1);
        this.setStack(2, new ItemStack(outputItem, current + additional));

        damageItem();
        resetProgress();
      } else {
        BlockState state = this.getCachedState();
        this.progress += knife.getMiningSpeedMultiplier(recipe.getOutput(), state);
      }
    }
  }
}
