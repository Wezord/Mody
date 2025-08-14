// com/wezord/mody/client/screen/BossSphereScreen.java
package com.wezord.mody.client.screen;

import com.wezord.mody.menu.BossSphereMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class BossSphereScreen extends AbstractContainerScreen<BossSphereMenu> {

    public BossSphereScreen(BossSphereMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderBg(GuiGraphics gfx, float partialTick, int mouseX, int mouseY) {
        // fond uni (pour tester). Tu peux dessiner une texture ici.
        // Exemple si tu as une texture: gfx.blit(TEXTURE, leftPos, topPos, 0,0, imageWidth, imageHeight);
    }

    @Override
    public void render(GuiGraphics gfx, int mouseX, int mouseY, float partialTick) {
        renderBackground(gfx, mouseY, mouseY, partialTick);
        super.render(gfx, mouseX, mouseY, partialTick);
        renderTooltip(gfx, mouseX, mouseY);
        gfx.drawCenteredString(this.font, "Boss Sphere (serveur)", this.width/2, this.topPos - 12, 0xFFFFFF);
    }
}
