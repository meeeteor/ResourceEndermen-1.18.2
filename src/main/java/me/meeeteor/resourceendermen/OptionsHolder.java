package me.meeeteor.resourceendermen;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class OptionsHolder {
    public static class Common {
        //default values:
        //chance for resourcepearls to drop their item:
        private static final Float defaultDiamondDropChance = 0.1f; //10%

        public final ForgeConfigSpec.ConfigValue<Float> diamondDropChance;


        public Common(ForgeConfigSpec.Builder builder){
            builder.push("The chance of a resource dropping when throwing a resourcepearl");
            this.diamondDropChance = builder.comment("The chance of a diamond dropping after throwing a diamond pearl")
                    .define("diamondPearlResourceDropChance", defaultDiamondDropChance);
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
