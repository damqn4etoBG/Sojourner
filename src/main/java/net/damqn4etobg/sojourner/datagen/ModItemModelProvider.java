package net.damqn4etobg.sojourner.datagen;

import net.damqn4etobg.sojourner.Sojourner;
import net.damqn4etobg.sojourner.block.ModBlocks;
import net.damqn4etobg.sojourner.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Sojourner.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RAW_BAUXITE);
        simpleItem(ModItems.RAW_ALUMINUM);
        simpleItem(ModItems.ALUMINUM_INGOT);
        simpleItem(ModItems.ALUMINUM_PLATE);
        simpleItem(ModItems.STEEL_ROD);
        simpleItem(ModItems.STEEL_PLATE);
        simpleItem(ModItems.REFINED_SILICON);
        simpleItem(ModItems.SOJOURNER_GUIDE);
        simpleItem(ModItems.BLANK_BLUEPRINT);
        simpleItem(ModItems.ROD_BLUEPRINT);
        simpleItem(ModItems.PLATE_BLUEPRINT);
        evenSimplerBlockItem(ModBlocks.BAUXITE_ORE);
        evenSimplerBlockItem(ModBlocks.DEEPSLATE_BAUXITE_ORE);
        evenSimplerBlockItem(ModBlocks.BLUEPRINT_INSCRIBER);
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Sojourner.MODID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(DeferredItem<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Sojourner.MODID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(DeferredBlock<Block> block) {
        this.withExistingParent(Sojourner.MODID + ":" + BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
                modLoc("block/" + BuiltInRegistries.BLOCK.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Sojourner.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Sojourner.MODID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Sojourner.MODID,"item/" + item.getId().getPath()));
    }
}
