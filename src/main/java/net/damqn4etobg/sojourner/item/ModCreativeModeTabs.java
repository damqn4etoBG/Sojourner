package net.damqn4etobg.sojourner.item;

import net.damqn4etobg.sojourner.Sojourner;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Sojourner.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SOJOURNER_TAB = CREATIVE_MODE_TABS.register("sojourner_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.sojourner"))
            .icon(() -> ModItems.BLANK_BLUEPRINT.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                for(DeferredHolder<Item, ? extends Item> items : ModItems.ITEMS.getEntries()) {
                    output.accept(items.get());
                }
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
