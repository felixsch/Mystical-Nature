package net.marwinka.mysticalcrops.registry;

import net.marwinka.mysticalcrops.items.Coals;
import net.marwinka.mysticalcrops.items.Souls;
import net.marwinka.mysticalcrops.items.tools.EssenceTool;
import net.marwinka.mysticalcrops.items.tools.InfinityTool;
import net.marwinka.mysticalcrops.items.tools.ToolMaterials;
import net.marwinka.mysticalcrops.items.tools.WateringCan;
import net.marwinka.mysticalcrops.util.block.BaseItem;
import net.marwinka.mysticalcrops.util.inventory.ModIdentifier;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.marwinka.mysticalcrops.MysticalCrops.ITEMGROUPCLASSIC;

public class ModItems {
    public static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();
    public static final Item COMMON_COAL = register(new Coals(1), "common_coal");
    public static final Item UNCOMMON_COAL = register(new Coals(2), "uncommon_coal");
    public static final Item WONDERFUL_COAL = register(new Coals(3), "wonderful_coal");
    public static final Item EXCELLENT_COAL = register(new Coals(4), "excellent_coal");
    public static final Item PERFECT_COAL = register(new Coals(5), "perfect_coal");

    public static final Item CRYSTAL_FRAGMENTS = register("crystal_fragments");

    public static final Item EMPTY_CRYSTAL = register("empty_crystal");

    public static final Item COMMON_ESSENCE = register("common_essence");
    public static final Item UNCOMMON_ESSENCE = register("uncommon_essence");
    public static final Item WONDERFUL_ESSENCE = register("wonderful_essence");
    public static final Item EXCELLENT_ESSENCE = register("excellent_essence");
    public static final Item PERFECT_ESSENCE = register("perfect_essence");

    public static final Item COMMON_CRYSTAL = register(new EssenceTool(ToolMaterials.COMMON_CRYSTAL), "common_crystal");
    public static final Item UNCOMMON_CRYSTAL = register(new EssenceTool(ToolMaterials.UNCOMMON_CRYSTAL), "uncommon_crystal");
    public static final Item WONDERFUL_CRYSTAL = register(new EssenceTool(ToolMaterials.WONDERFUL_CRYSTAL), "wonderful_crystal");
    public static final Item EXCELLENT_CRYSTAL = register(new EssenceTool(ToolMaterials.EXCELLENT_CRYSTAL), "excellent_crystal");
    public static final Item PERFECT_CRYSTAL = register(new EssenceTool(ToolMaterials.PERFECT_CRYSTAL), "perfect_crystal");
    public static final Item INFINITY_CRYSTAL = register(new InfinityTool(ToolMaterials.PERFECT_CRYSTAL),"infinity_crystal");

    public static final Item DARK_CRYSTAL = register("dark_crystal");

    public static final Item WITHER_CRYSTAL = register("wither_crystal");
    public static final Item WITHER_SOUL = register(new Souls(),"wither_soul");

    public static final Item COW_CRYSTAL = register("cow_crystal");
    public static final Item COW_SOUL = register(new Souls(),"cow_soul");

    public static final Item CHICKEN_CRYSTAL = register("chicken_crystal");
    public static final Item CHICKEN_SOUL = register(new Souls(),"chicken_soul");

    public static final Item SHEEP_CRYSTAL = register("sheep_crystal");
    public static final Item SHEEP_SOUL = register(new Souls(),"sheep_soul");

    public static final Item CRAFT_SEEDS = register("craft_seeds");
    public static final Item UNCOMMON_CRAFT_SEEDS = register("uncommon_craft_seeds");
    public static final Item WONDERFUL_CRAFT_SEEDS = register("wonderful_craft_seeds");
    public static final Item EXCELLENT_CRAFT_SEEDS = register("excellent_craft_seeds");
    public static final Item PERFECT_CRAFT_SEEDS = register("perfect_craft_seeds");

    public static final Item COMMON_INGOT = register("common_ingot");
    public static final Item UNCOMMON_INGOT = register("uncommon_ingot");
    public static final Item WONDERFUL_INGOT = register("wonderful_ingot");
    public static final Item EXCELLENT_INGOT = register("excellent_ingot");
    public static final Item PERFECT_INGOT = register("perfect_ingot");
    public static final Item INFINITY_INGOT = register("infinity_ingot");

    public static final Item COMMON_KNIFE = register(new EssenceTool(ToolMaterials.COMMON_KNIFE), "common_knife");
    public static final Item UNCOMMON_KNIFE = register(new EssenceTool(ToolMaterials.UNCOMMON_KNIFE), "uncommon_knife");
    public static final Item WONDERFUL_KNIFE = register(new EssenceTool(ToolMaterials.WONDERFUL_KNIFE), "wonderful_knife");
    public static final Item EXCELLENT_KNIFE = register(new EssenceTool(ToolMaterials.EXCELLENT_KNIFE), "excellent_knife");
    public static final Item PERFECT_KNIFE = register(new EssenceTool(ToolMaterials.PERFECT_KNIFE), "perfect_knife");
    public static final Item INFINITY_KNIFE = register(new InfinityTool(ToolMaterials.PERFECT_KNIFE),"infinity_knife");

    public static final Item WATERING_CAN = register(new WateringCan(3, 0.5, 0), "watering_can");
    public static final Item COMMON_WATERING_CAN = register(new WateringCan(5, 0.6, 1), "common_watering_can");
    public static final Item UNCOMMON_WATERING_CAN = register(new WateringCan(7, 0.7, 2), "uncommon_watering_can");
    public static final Item WONDERFUL_WATERING_CAN = register(new WateringCan(9, 0.8, 3), "wonderful_watering_can");
    public static final Item EXCELLENT_WATERING_CAN = register(new WateringCan(11, 0.9, 4), "excellent_watering_can");
    public static final Item PERFECT_WATERING_CAN = register(new WateringCan(13, 1, 5), "perfect_watering_can");

    private static Item register(String name) {
        return register(new BaseItem(p -> p.group(ITEMGROUPCLASSIC)), name);
    }
    private static Item register(Item item, String name) {
        ITEMS.put(item, new ModIdentifier(name));
        return item;
    }

    public static void registerItems() {
        ITEMS.forEach((item, id) -> Registry.register(Registry.ITEM, id, item));
    }
}
