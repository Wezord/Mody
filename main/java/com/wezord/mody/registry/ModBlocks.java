package com.wezord.mody.registry;

import com.wezord.mody.ModConstants;
import com.wezord.mody.content.BossSphere;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public final class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModConstants.MODID);

    public static final RegistryObject<Block> BOSS_SPHERE = BLOCKS.register("boss_sphere",
        () -> new BossSphere(
            net.minecraft.world.level.block.state.BlockBehaviour.Properties.of()
                .setId(BLOCKS.key("boss_sphere"))
                .strength(3.0f, 6.0f)
        )
    );

}