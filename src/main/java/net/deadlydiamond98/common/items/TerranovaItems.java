package net.deadlydiamond98.common.items;

import net.deadlydiamond98.Terranova;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class TerranovaItems {

    public static final List<Item> ITEMS = new ArrayList<>();

    public static final Item TOKEN = register("token", new Item(new FabricItemSettings()));
    public static final Item BORDER_TOKEN = register("border_token", new BorderTokenItem(new FabricItemSettings()));

    public static Item register(String name, Item item) {
        Item registerd = Registry.register(Registries.ITEM, new Identifier(Terranova.MOD_ID, name), item);
        ITEMS.add(registerd);
        return registerd;
    }

    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((entries) -> ITEMS.forEach(entries::add));
    }
}
