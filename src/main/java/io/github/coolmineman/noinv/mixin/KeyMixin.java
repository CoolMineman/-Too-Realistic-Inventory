package io.github.coolmineman.noinv.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Hand;

import org.spongepowered.asm.mixin.injection.At;


@Mixin(net.minecraft.client.options.KeyBinding.class)
public class KeyMixin {
    @Shadow
    private InputUtil.KeyCode defaultKeyCode;
    @Shadow
    private int timesPressed;
    @Shadow
    public String getId() {return null;}

    @Inject(at = @At("HEAD"), method = "wasPressed", cancellable = true)
    public void wasPressed(CallbackInfoReturnable<Boolean> bruh) {
        MinecraftClient mc = MinecraftClient.getInstance();
        Boolean nopeOut = false;
        if (defaultKeyCode.getKeyCode() == 81) {
            if ("item.noinv.blocker_item".equals((mc.player.getStackInHand(Hand.MAIN_HAND).getItem().getTranslationKey()))) {
                timesPressed = 0;
                bruh.setReturnValue(false);
            }
        }
        if (defaultKeyCode.getKeyCode() == 48) {
            nopeOut = true;
        }
        if ((defaultKeyCode.getKeyCode() >= 50) && (defaultKeyCode.getKeyCode() <= 57)) {
            nopeOut = true;
        }

        if (nopeOut) {
            timesPressed = 0;
            bruh.setReturnValue(false);
        } else {
            if (this.timesPressed != 0) {
                
            }
        }

    }
}