package com.wasadog91.linearlevels;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ClientConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    static {
        BUILDER.push("Client Settings");
    }

    // Example toggle
    public static final ModConfigSpec.BooleanValue ENABLE_XP_BAR = BUILDER
            .comment("Display flat XP bar in HUD")
            .define("showXpBar", true);

    // XP per level (client-side, optional)
    public static final ModConfigSpec.IntValue XP_PER_LEVEL = BUILDER
            .comment("Client-side override: how much XP is shown per level")
            .defineInRange("xpPerLevel", 10, 1, Integer.MAX_VALUE);

    static {
        BUILDER.pop(); // end category
    }

    public static final ModConfigSpec SPEC = BUILDER.build();
}
