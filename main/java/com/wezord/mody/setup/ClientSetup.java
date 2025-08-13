package com.wezord.mody.setup;

import com.wezord.mody.ModConstants;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public final class ClientSetup {
    private ClientSetup() {}

    public static void onClientSetup(final FMLClientSetupEvent e) {
        ModConstants.LOGGER.info("[MODY] Client setup; user={}", Minecraft.getInstance().getUser().getName());
        // TODO: block render layers, menus, keybinds, screens, item properties...
    }
}