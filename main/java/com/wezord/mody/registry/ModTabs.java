package com.wezord.mody.registry;

import com.wezord.mody.ModConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModConstants.MODID);

    public static final RegistryObject<CreativeModeTab> MODY_TAB = TABS.register("mody_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(CreativeModeTabs.BUILDING_BLOCKS)
                    .icon(() -> ModItems.BOSS_SPHERE_ITEM.get().getDefaultInstance())
                    .displayItems((params, output) -> {
                        output.accept(ModItems.BOSS_SPHERE_ITEM.get());
                    }).build());

    private ModTabs() {}

    // Séparation du remplissage d’onglets vanilla
    public static void fillVanillaTabs(BuildCreativeModeTabContentsEvent e) {
        if (e.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            e.accept(ModItems.BOSS_SPHERE_ITEM);
        }
    }
}