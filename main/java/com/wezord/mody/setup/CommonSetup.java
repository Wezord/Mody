package com.wezord.mody.setup;

import com.wezord.mody.config.Config;
import com.wezord.mody.ModConstants;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public final class CommonSetup {
    private CommonSetup() {}

    public static void onCommonSetup(final FMLCommonSetupEvent e) {
        ModConstants.LOGGER.info("[MODY] Common setup");
        ModConstants.LOGGER.info("Hardness={}, Resistance={}, Light={}",
                Config.hardness.get(), Config.resistance.get(), Config.lightLevel.get());
        // TODO: réseau, compat, registries dynamiques, etc.
    }
}