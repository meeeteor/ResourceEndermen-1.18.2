package me.meeeteor.resourceendermen.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab RESOURCEENDERMEN_TAB = new CreativeModeTab("resourceendermentab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DIAMOND_PEARL.get());
        }
    };
}
