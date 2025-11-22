package com.wasadog91.linearlevels.mixin;

import com.wasadog91.linearlevels.Config;
import com.wasadog91.linearlevels.LinearLevels;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;


@Mixin(Player.class)
public abstract class PlayerXpMixin {
    /**
     * Fully overwrite Minecraft's built‑in XP formula.
     * Vanilla uses an exponential-like curve; we replace it with a flat 15 XP.
     */
    @Overwrite
    public int getXpNeededForNextLevel() {
        return  Config.XP_PER_LEVEL.get();
    }
}