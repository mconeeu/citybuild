/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.plugin.Inventorys;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventoryOption;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.coresystem.api.bukkit.item.Skull;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class HeadInventory extends CoreInventory {

    public HeadInventory(Player p, String playername) {
        super("§f§lKopf Kauf von " + playername, p, InventorySlot.ROW_1, InventoryOption.FILL_EMPTY_SLOTS);

        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        setItem(InventorySlot.ROW_1_SLOT_5, new Skull(playername, 1).toItemBuilder().create());


        setItem(InventorySlot.ROW_1_SLOT_7, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, 1).displayName("§a§lKaufen").lore("§6§o35.000 Coins").create(),
                e -> {

                    if (cp.getCoins() - 35000 >= 0) {
                        cp.removeCoins(35000);
                        p.getInventory().addItem(new Skull(playername, 1).toItemBuilder().displayName("§f§l" + playername + "´s Kopf").create());

                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                        p.sendMessage("§8[§7§l!§8] §fSystem §8» §aDu hast das Item erfolgreich gekauft");
                    } else {
                        p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast nicht genügend Coins!");
                    }

                });

        setItem(InventorySlot.ROW_1_SLOT_3, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE, 1).displayName("§c§lAbbrechen").lore("§6§oBreche den Kauf ab").create(),
                e -> {


                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
                    p.sendMessage("§8[§7§l!§8] §fSystem §8» §cDu hast erfolgreich abgebrochen");


                });

        openInventory();
    }

}
