/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.Inventorys.trader;

import eu.mcone.citybuild.item.ShopCategory;
import org.bukkit.entity.Player;

public class TraderItemListInventory extends TraderInventory {

    public TraderItemListInventory(Player p) {
        super(ShopCategory.ITEM_LIST, p);
        openInventory();
    }

}
