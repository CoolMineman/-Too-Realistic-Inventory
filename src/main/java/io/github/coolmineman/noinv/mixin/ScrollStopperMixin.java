package io.github.coolmineman.noinv.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.entity.player.PlayerInventory.class)
public class ScrollStopperMixin {
    @Inject(at = @At("HEAD"), method = "scrollInHotbar", cancellable = true)
    public void scrollInHotbar(double scrollAmount, CallbackInfo bruh) {
        bruh.cancel();
    }

}