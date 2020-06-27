package io.github.coolmineman.noinv.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;

@Mixin(net.minecraft.server.network.ServerPlayNetworkHandler.class)
public class PacketSwapMixin {
    @Shadow
    public ServerPlayerEntity player;

    @Inject(at = @At("HEAD"), method = "onPlayerAction", cancellable = true)
    public void onPlayerAction(PlayerActionC2SPacket packet, CallbackInfo bruh) {
        if (packet.getAction().equals(PlayerActionC2SPacket.Action.SWAP_HELD_ITEMS)) {
            if ("item.noinv.blocker_item".equals((this.player.getStackInHand(Hand.MAIN_HAND).getItem().getTranslationKey()))) {
                bruh.cancel();
            }
        }
    }
}