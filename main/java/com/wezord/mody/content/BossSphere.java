package com.wezord.mody.content;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;

public class BossSphere extends Block {
    public BossSphere(Properties P) {
        super(P);
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            player.displayClientMessage(Component.literal("CustomBlock: hello!"), true);
        }
        // SUCCESS côté client pour l'animation, CONSUME côté serveur pour indiquer qu'on a géré l'action.
        return level.isClientSide ? InteractionResult.SUCCESS : InteractionResult.CONSUME;
    }
}