package net.marwinka.mysticalcrops.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.marwinka.mysticalcrops.MysticalCrops;
import net.marwinka.mysticalcrops.block.ModBlockRegister;
import net.marwinka.mysticalcrops.entity.BotanicalTableEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntityRegister {
    public static BlockEntityType<BotanicalTableEntity> BOTANICAL_TABLE;
    public static BlockEntityType<BotanicalRitualTableEntity> BOTANICAL_RITUAL_TABLE;

    public static void registerBlockEntities() {
        BOTANICAL_TABLE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(MysticalCrops.MOD_ID, "botanical_table"),
                FabricBlockEntityTypeBuilder.create(BotanicalTableEntity::new,
                        ModBlockRegister.BOTANICAL_TABLE).build(null));

        BOTANICAL_RITUAL_TABLE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(MysticalCrops.MOD_ID, "botanical_ritual_table"),
                FabricBlockEntityTypeBuilder.create(BotanicalRitualTableEntity::new,
                        ModBlockRegister.BOTANICAL_RITUAL_TABLE).build(null));
    }
}