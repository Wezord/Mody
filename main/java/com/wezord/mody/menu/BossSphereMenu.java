// com/wezord/mody/menu/BossSphereMenu.java
package com.wezord.mody.menu;

import com.wezord.mody.registry.ModMenus;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BossSphereMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess access;
    private final Level level;
    private final BlockPos pos;

    // Factory used on the client when opening via network
    public static BossSphereMenu fromNetwork(int id, Inventory inv, FriendlyByteBuf buf) {
        BlockPos pos = buf.readBlockPos();
        return new BossSphereMenu(id, inv, pos);
    }

    // Called on client
    public BossSphereMenu(int id, Inventory inv, BlockPos pos) {
        this(id, inv, ContainerLevelAccess.NULL);
    }

    // Called on server
    public BossSphereMenu(int id, Inventory inv, ContainerLevelAccess access) {
        super(ModMenus.BOSS_SPHERE_MENU.get(), id);
        this.access = access;
        this.level = inv.player.level();
        this.pos = access.evaluate((lvl, p) -> p, null); // Optional: store the pos from access

        int left = 8;
        int top = 84;

        // Player inventory slots (3 rows)
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(inv, col + row * 9 + 9, left + col * 18, top + row * 18));
            }
        }
        // Hotbar slots
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(inv, col, left + col * 18, top + 58));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return access.evaluate((lvl, pos) ->
                player.distanceToSqr(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5) <= 64.0,
                true);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }
}
