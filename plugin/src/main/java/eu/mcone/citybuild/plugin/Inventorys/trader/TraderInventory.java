/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.plugin.Inventorys.trader;

import eu.mcone.citybuild.api.item.ShopCategory;
import eu.mcone.coresystem.api.bukkit.inventory.category.StaticClassCategoryInventory;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public abstract class TraderInventory extends StaticClassCategoryInventory {

    private static final Map<ShopCategory, Class<? extends TraderInventory>> inventories = new HashMap<>();

    public TraderInventory(ShopCategory category, Player p) {
        super("§8» §e§lHändler §8| §f" + category.getName(), p);

        for (ShopCategory cat : ShopCategory.values()) {
            addCategoryWithInventoryClass(cat.getItem(), inventories.get(cat));
        }
    }

    public static void registerBackpackInventory(ShopCategory category, Class<? extends TraderInventory> inventory) {
        inventories.put(category, inventory);
    }

    public static void openNewInventory(ShopCategory category, Player player) {
        try {
            inventories.get(category).getConstructor(Player.class).newInstance(player).openInventory();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
