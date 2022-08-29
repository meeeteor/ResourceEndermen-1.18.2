package me.meeeteor.resourceendermen.item;

import me.meeeteor.resourceendermen.ResourceEndermen;
import me.meeeteor.resourceendermen.item.custom.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ResourceEndermen.MOD_ID);

    //Pearls
    public static final RegistryObject<Item> IRON_PEARL = ITEMS.register("iron_pearl", () -> new IronpearlItem(new Item.Properties().stacksTo(16).tab(ModCreativeModeTab.RESOURCEENDERMEN_TAB)));
    public static final RegistryObject<Item> COPPER_PEARL = ITEMS.register("copper_pearl", () -> new CopperpearlItem(new Item.Properties().stacksTo(16).tab(ModCreativeModeTab.RESOURCEENDERMEN_TAB)));
    public static final RegistryObject<Item> GOLD_PEARL = ITEMS.register("gold_pearl", () -> new GoldpearlItem(new Item.Properties().stacksTo(16).tab(ModCreativeModeTab.RESOURCEENDERMEN_TAB)));
    public static final RegistryObject<Item> DIAMOND_PEARL = ITEMS.register("diamond_pearl", () -> new DiamondpearlItem(new Item.Properties().stacksTo(16).tab(ModCreativeModeTab.RESOURCEENDERMEN_TAB)));
    public static final RegistryObject<Item> EMERALD_PEARL = ITEMS.register("emerald_pearl", () -> new EmeraldpearlItem(new Item.Properties().stacksTo(16).tab(ModCreativeModeTab.RESOURCEENDERMEN_TAB)));
    public static final RegistryObject<Item> QUARTZ_PEARL = ITEMS.register("quartz_pearl", () -> new QuartzpearlItem(new Item.Properties().stacksTo(16).tab(ModCreativeModeTab.RESOURCEENDERMEN_TAB)));
    public static final RegistryObject<Item> BLAZE_PEARL = ITEMS.register("blaze_pearl", () -> new BlazepearlItem(new Item.Properties().stacksTo(16).tab(ModCreativeModeTab.RESOURCEENDERMEN_TAB)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
