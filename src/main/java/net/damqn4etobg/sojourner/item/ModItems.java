package net.damqn4etobg.sojourner.item;

import net.damqn4etobg.sojourner.Sojourner;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
    public static final DeferredItem<Item> BLANK_BLUEPRINT = ITEMS.registerSimpleItem("blank_blueprint", new Item.Properties());
    public static final DeferredItem<Item> ROD_BLUEPRINT =  ITEMS.register("rod_blueprint", () -> new Item(new Item.Properties()) {
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pIsAdvanced) {
            pTooltip.add(Component.translatable("tooltip.sojourner.rod_blueprint"));
        }
    });
    public static final DeferredItem<Item> PLATE_BLUEPRINT =  ITEMS.register("plate_blueprint", () -> new Item(new Item.Properties()) {
        @Override
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pIsAdvanced) {
            pTooltip.add(Component.translatable("tooltip.sojourner.plate_blueprint"));
        }
    });

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
