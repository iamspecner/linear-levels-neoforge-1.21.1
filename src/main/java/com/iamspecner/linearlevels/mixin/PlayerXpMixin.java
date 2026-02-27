package com.iamspecner.linearlevels.mixin;

import com.iamspecner.linearlevels.Config;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Player.class)
public abstract class PlayerXpMixin {

    @Inject(
            method = "getXpNeededForNextLevel",
            at = @At("HEAD"),
            cancellable = true
    )
    private void linearlevels$overrideXp(CallbackInfoReturnable<Integer> cir) {
        if(Config.MOD_ENABLED.get()){
            cir.setReturnValue(Config.XP_PER_LEVEL.get());
        }
    }



}