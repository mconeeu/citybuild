/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.Inventorys.trader;

import eu.mcone.citybuild.item.ShopCategory;
import eu.mcone.coresystem.api.bukkit.inventory.category.StaticClassCategoryInventory;
import org.bukkit.entity.Player;

public abstract class TraderInventory extends StaticClassCategoryInventory {

    public TraderInventory(ShopCategory category, Player p) {
        super("§8» §e§lHändler §8| §f"+category.getName(), p);

        for (ShopCategory cat : ShopCategory.values()) {
            addCategoryWithInventoryClass(cat.getItem(), cat.getInvClass());
        }
    }

}
