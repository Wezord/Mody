package com.wezord.mody.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class Config {
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.IntValue lightLevel;
    public static final ForgeConfigSpec.DoubleValue hardness;
    public static final ForgeConfigSpec.DoubleValue resistance;

    static {
        ForgeConfigSpec.Builder b = new ForgeConfigSpec.Builder();
        b.push("custom_block");
        lightLevel = b.defineInRange("lightLevel", 7, 0, 15);
        hardness   = b.defineInRange("hardness", 1.5D, 0.0D, 10000.0D);
        resistance = b.defineInRange("resistance", 6.0D, 0.0D, 10000.0D);
        b.pop();
        SPEC = b.build(); // <-- JAMAIS null
    }

    private Config() {}
}