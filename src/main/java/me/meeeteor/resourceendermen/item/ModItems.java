package me.meeeteor.resourceendermen.item;

import me.meeeteor.resourceendermen.ResourceEndermen;
import me.meeeteor.resourceendermen.item.custom.DiamondpearlItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ResourceEndermen.MOD_ID);

    public static final RegistryObject<Item> DIAMOND_PEARL =
            ITEMS.register("diamond_pearl", () -> new DiamondpearlItem(new Item.Properties()
                    .stacksTo(16)
                    .tab(ModCreativeModeTab.RESOURCEENDERMEN_TAB)
            ));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
