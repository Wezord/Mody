package com.wezord.mody.registry;

import com.wezord.mody.ModConstants;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ModConstants.MODID);

 // Son BlockItem pour l’inventaire
    public static final RegistryObject<Item> BOSS_SPHERE_ITEM = ITEMS.register("boss_sphere",
            () -> new BlockItem(ModBlocks.BOSS_SPHERE.get(), 
            		new Item.Properties().setId(ITEMS.key("boss_sphere"))));

}