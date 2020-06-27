package io.github.coolmineman.noinv.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.coolmineman.noinv.NoInv;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;

@Mixin(net.minecraft.entity.player.PlayerEntity.class)
public class PlayerEntityMixin {
    @Shadow
    public PlayerInventory inventory;

    @Inject(at = @At(value="HEAD", ordinal=1), method = "dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;", cancellable = true)
    public void dropItem(ItemStack stack, boolean bl, boolean bl2, CallbackInfoReturnable<ItemEntity> bruh) {
        if ("item.noinv.blocker_item".equals(stack.getItem().getTranslationKey())){
            this.inventory.setInvStack(this.inventory.selectedSlot, new ItemStack(NoInv.BLOCKER_ITEM, 1));
            bruh.setReturnValue(null);
        }
    }
}