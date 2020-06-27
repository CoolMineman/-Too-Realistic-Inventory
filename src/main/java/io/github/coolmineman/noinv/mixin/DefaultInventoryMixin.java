package io.github.coolmineman.noinv.mixin;

import com.mojang.authlib.GameProfile;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.coolmineman.noinv.NoInv;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@Mixin(net.minecraft.server.network.ServerPlayerEntity.class)
public class DefaultInventoryMixin extends PlayerEntity {

    public DefaultInventoryMixin(World world, GameProfile profile) {
        super(world, profile);
    }

    @Inject(at = @At(value = "HEAD"), method = "method_14235")
    public void method_14235(CallbackInfo bruh) {
        for (int i = 1; i <= 35; i++) {
            super.inventory.setInvStack(i, new ItemStack(NoInv.BLOCKER_ITEM, 1));
        }
    }

    @Shadow
    public boolean isSpectator() {return false;}

    @Shadow
    public boolean isCreative() {return false;}
}