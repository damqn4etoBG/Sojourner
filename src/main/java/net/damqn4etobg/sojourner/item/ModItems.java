package net.damqn4etobg.sojourner.item;

import net.damqn4etobg.sojourner.Sojourner;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import vazkii.patchouli.common.book.Book;
import vazkii.patchouli.common.item.ItemModBook;
import vazkii.patchouli.common.item.PatchouliItems;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Sojourner.MODID);

    public static final DeferredItem<Item> RAW_BAUXITE = ITEMS.registerSimpleItem("raw_bauxite", new Item.Properties());
    public static final DeferredItem<Item> RAW_ALUMINUM = ITEMS.registerSimpleItem("raw_aluminum", new Item.Properties());
    public static final DeferredItem<Item> ALUMINUM_INGOT = ITEMS.registerSimpleItem("aluminum_ingot", new Item.Properties());
    public static final DeferredItem<Item> ALUMINUM_PLATE = ITEMS.registerSimpleItem("aluminum_plate", new Item.Properties());
    public static final DeferredItem<Item> STEEL_ROD = ITEMS.registerSimpleItem("steel_rod", new Item.Properties());
    public static final DeferredItem<Item> STEEL_PLATE = ITEMS.registerSimpleItem("steel_plate", new Item.Properties());
    public static final DeferredItem<Item> REFINED_SILICON = ITEMS.registerSimpleItem("refined_silicon", new Item.Properties());
    public static final DeferredItem<Item> SOJOURNER_GUIDE = ITEMS.registerSimpleItem("sojourner_guide", new Item.Properties());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
