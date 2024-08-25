package net.damqn4etobg.sojourner.datagen;

import net.damqn4etobg.sojourner.Sojourner;
import net.damqn4etobg.sojourner.block.ModBlocks;
import net.damqn4etobg.sojourner.tag.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Sojourner.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(Tags.Blocks.ORES)
                .add(ModBlocks.BAUXITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_BAUXITE_ORE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BAUXITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_BAUXITE_ORE.get())
                .add(ModBlocks.BLUEPRINT_INSCRIBER.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.BAUXITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_BAUXITE_ORE.get())
                .add(ModBlocks.BLUEPRINT_INSCRIBER.get());
        this.tag(ModTags.Blocks.ORES_BAUXITE)
                .add(ModBlocks.BAUXITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_BAUXITE_ORE.get());
    }
}
