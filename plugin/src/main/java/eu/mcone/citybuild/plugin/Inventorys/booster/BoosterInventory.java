/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.plugin.Inventorys.booster;

import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventoryOption;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import org.bukkit.entity.Player;

public class BoosterInventory extends CoreInventory {

    public BoosterInventory(Player p) {
        super("§f§lDeine Booster", p, InventorySlot.ROW_3, InventoryOption.FILL_EMPTY_SLOTS);
        openInventory();
    }
}
