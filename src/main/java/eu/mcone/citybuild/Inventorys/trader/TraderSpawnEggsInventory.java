/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.Inventorys.trader;

import eu.mcone.citybuild.Citybuild;
import eu.mcone.citybuild.item.ShopCategory;
import eu.mcone.citybuild.item.ShopItem;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class TraderSpawnEggsInventory extends TraderInventory {

    public TraderSpawnEggsInventory(Player p) {
        super(ShopCategory.SPAWN_EGGS, p);
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        for (ShopItem item : ShopItem.values()) {
            if (item.getCategory().equals(ShopCategory.SPAWN_EGGS)) {
                addItem(item.getRawItem().lore(item.getShopLore()).create(), e -> {
                    if (cp.getCoins() - item.getPrice() >= 0) {
                        cp.removeCoins(item.getPrice());
                        p.getInventory().addItem(item.getRawItem().create());

                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    } else {
                        Citybuild.getInstance().getMessager().send(p, "§4Du hast nicht genügend Coins!");
                    }
                });
            }
        }

        openInventory();
    }
}
