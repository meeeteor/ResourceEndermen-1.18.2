package me.meeeteor.resourceendermen;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class OptionsHolder {
    public static class Common {
        //default values:
        //chance for resourcepearls to drop their item:
        private static final Float defaultIronDropChance = 0.01f; //1%
        private static final Float defaultCopperDropChance = 0.01f; //1%
        private static final Float defaultGoldDropChance = 0.01f; //1%
        private static final Float defaultDiamondDropChance = 0.01f; //1%
        private static final Float defaultEmeraldDropChance = 0.01f; //1%
        private static final Float defaultQuartzDropChance = 0.01f; //1%
        private static final Float defaultBlazeDropChance = 0.01f; //1%

        public final ForgeConfigSpec.ConfigValue<Float> ironDropChance;
        public final ForgeConfigSpec.ConfigValue<Float> copperDropChance;
        public final ForgeConfigSpec.ConfigValue<Float> goldDropChance;
        public final ForgeConfigSpec.ConfigValue<Float> diamondDropChance;
        public final ForgeConfigSpec.ConfigValue<Float> emeraldDropChance;
        public final ForgeConfigSpec.ConfigValue<Float> quartzDropChance;
        public final ForgeConfigSpec.ConfigValue<Float> blazeDropChance;


        public Common(ForgeConfigSpec.Builder builder){
            builder.push("The chance of a resource dropping when throwing a resourcepearl");
            this.ironDropChance = builder.comment("The chance of an iron ingot dropping after throwing a diamond pearl")
                    .define("ironPearlResourceDropChance", defaultIronDropChance);
            this.copperDropChance = builder.comment("The chance of a copper ingot dropping after throwing a diamond pearl")
                    .define("copperPearlResourceDropChance", defaultCopperDropChance);
            this.goldDropChance = builder.comment("The chance of a gold ingot dropping after throwing a diamond pearl")
                    .define("goldPearlResourceDropChance", defaultGoldDropChance);
            this.diamondDropChance = builder.comment("The chance of a diamond dropping after throwing a diamond pearl")
                    .define("diamondPearlResourceDropChance", defaultDiamondDropChance);
            this.emeraldDropChance = builder.comment("The chance of an emerald dropping after throwing a diamond pearl")
                    .define("emeraldPearlResourceDropChance", defaultEmeraldDropChance);
            this.quartzDropChance = builder.comment("The chance of nether quartz dropping after throwing a diamond pearl")
                    .define("quartzPearlResourceDropChance", defaultQuartzDropChance);
            this.blazeDropChance = builder.comment("The chance of blaze powder dropping after throwing a diamond pearl")
                    .define("blazePearlResourceDropChance", defaultBlazeDropChance);
            builder.pop();
        }
    }

    public static final Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    static { //constructor
        Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON = commonSpecPair.getLeft();
        COMMON_SPEC = commonSpecPair.getRight();
    }
}
