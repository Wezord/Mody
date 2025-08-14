package com.wezord.mody.registry;

import com.wezord.mody.ModConstants;
import com.wezord.mody.menu.BossSphereMenu;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModMenus {
	public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, ModConstants.MODID);

	public static final RegistryObject<MenuType<BossSphereMenu>> BOSS_SPHERE_MENU =
            MENUS.register("boss_sphere",
                    () -> IForgeMenuType.create((IContainerFactory<BossSphereMenu>) BossSphereMenu::fromNetwork));

}
