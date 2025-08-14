package com.wezord.mody.content;

import com.wezord.mody.menu.BossSphereMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BossSphere extends Block {
    public BossSphere(Properties P) {
        super(P);
    }
    
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player,
    		BlockHitResult result) {
    	
    	if (!level.isClientSide && player instanceof ServerPlayer sp ) {
    		player.displayClientMessage(Component.literal("Clique droit !"), dynamicShape);
    		SimpleMenuProvider provider = new SimpleMenuProvider(
    	            (id, inv, ply) -> new BossSphereMenu(id, inv, ContainerLevelAccess.create(level, pos)),
    	            Component.translatable("screen.mody.boss_sphere")
    	        );
    		sp.openMenu(provider, buf -> buf.writeBlockPos(pos));
    	}
    	return net.minecraft.world.InteractionResult.SUCCESS;
    }
    
    
    
}