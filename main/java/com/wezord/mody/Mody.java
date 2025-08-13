package com.wezord.mody;

import com.wezord.mody.registry.ModBlocks;
import com.wezord.mody.registry.ModItems;
import com.wezord.mody.registry.ModTabs;
import com.wezord.mody.setup.ClientSetup;
import com.wezord.mody.setup.CommonSetup;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.wezord.mody.ModConstants.MODID;

@Mod(MODID)
public final class Mody {
    public Mody(FMLJavaModLoadingContext context) {
        var busGroup = context.getModBusGroup();

        // Enregistrer vos listeners
        FMLCommonSetupEvent.getBus(busGroup).addListener(CommonSetup::onCommonSetup);
        FMLClientSetupEvent.getBus(busGroup).addListener(ClientSetup::onClientSetup);
        BuildCreativeModeTabContentsEvent.getBus(busGroup).addListener(ModTabs::fillVanillaTabs);

        // Registries
        ModBlocks.BLOCKS.register(busGroup);
        ModItems.ITEMS.register(busGroup);
        ModTabs.TABS.register(busGroup);

        // Config
        context.registerConfig(ModConfig.Type.COMMON, com.wezord.mody.config.Config.SPEC);
    }
}
