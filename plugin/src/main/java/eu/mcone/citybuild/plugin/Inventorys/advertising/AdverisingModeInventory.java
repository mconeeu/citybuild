/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.plugin.Inventorys.advertising;

import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class AdverisingModeInventory extends CoreInventory {

    enum Mode {
        SHOP, EVENT
    }

    public AdverisingModeInventory(Player p) {
        super("§f§lWas möchtest du bewerben?", p, InventorySlot.ROW_3);

        setItem(InventorySlot.ROW_2_SLOT_7, new ItemBuilder(Material.ENCHANTING_TABLE).displayName("§5§lEin Event").create(), e -> {
            new AdverisingModeLevelInventory(p, Mode.EVENT);
        });

        setItem(InventorySlot.ROW_2_SLOT_3, new ItemBuilder(Material.CHEST).displayName("§a§lEin Shop").create(), e -> {
            new AdverisingModeLevelInventory(p, Mode.SHOP);
        });

        openInventory();
    }

}
