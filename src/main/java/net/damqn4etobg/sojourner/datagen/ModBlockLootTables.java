package net.damqn4etobg.sojourner.datagen;

import net.damqn4etobg.sojourner.block.ModBlocks;
import net.damqn4etobg.sojourner.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Set;
import java.util.stream.Collectors;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.add(ModBlocks.BAUXITE_ORE.get(), block -> this.createOreDrop(block, ModItems.RAW_BAUXITE.get()));
        this.add(ModBlocks.DEEPSLATE_BAUXITE_ORE.get(), block -> this.createOreDrop(block, ModItems.RAW_BAUXITE.get()));
        this.dropNothing(ModBlocks.BLUEPRINT_INSCRIBER.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(entry -> entry.get()).collect(Collectors.toList());
    }

    private void dropNothing(Block block) {
        this.add(block, LootTable.lootTable());
    }
}
