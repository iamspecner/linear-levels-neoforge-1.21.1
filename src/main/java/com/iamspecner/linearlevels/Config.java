package com.iamspecner.linearlevels;



import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue MOD_ENABLED = BUILDER
            .comment("Enables and Disables Mod")
            .define("ModEnabled", true);


    public static final ModConfigSpec.IntValue XP_PER_LEVEL = BUILDER
            .comment("How much XP is required per level")
            .defineInRange("xpPerLevel", 10, 1, Integer.MAX_VALUE);

    public static final ModConfigSpec SPEC = BUILDER.build();


}
