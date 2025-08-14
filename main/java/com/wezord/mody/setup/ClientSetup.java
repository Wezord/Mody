package com.wezord.mody.setup;

import com.wezord.mody.ModConstants;
import com.wezord.mody.client.screen.BossSphereScreen;
import com.wezord.mody.registry.ModMenus;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public final class ClientSetup {
    private ClientSetup() {}

    public static void onClientSetup(final FMLClientSetupEvent e) {
        ModConstants.LOGGER.info("[MODY] Client setup; user={}", Minecraft.getInstance().getUser().getName());
        // TODO: block render layers, menus, keybinds, screens, item properties...
        e.enqueueWork(() -> MenuScreens.register(ModMenus.BOSS_SPHERE_MENU.get(), BossSphereScreen::new));
    }
}