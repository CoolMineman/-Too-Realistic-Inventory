package io.github.coolmineman.noinv.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.injection.At;

@Mixin(net.minecraft.container.Slot.class)
public class SlotMixin {
    @Shadow
    public ItemStack getStack() {return null;} //Stub For Real Method

    @Inject(at = @At("HEAD"), method = "canTakeItems", cancellable = true)
    public void canTakeItems(PlayerEntity playerEntity, CallbackInfoReturnable<Boolean> bruh) {
        if ("item.noinv.blocker_item".equals(getStack().getItem().getTranslationKey())){
            bruh.setReturnValue(false);
        }
    }

}