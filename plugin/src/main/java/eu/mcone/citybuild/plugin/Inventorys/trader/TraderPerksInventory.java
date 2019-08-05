/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.plugin.Inventorys.trader;

import eu.mcone.citybuild.plugin.Citybuild;
import eu.mcone.citybuild.api.item.Perk;
import eu.mcone.citybuild.api.item.ShopCategory;
import eu.mcone.citybuild.api.player.CitybuildPlayer;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TraderPerksInventory extends TraderInventory {

    public TraderPerksInventory(Player p) {
        super(ShopCategory.PERKS, p);
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);
        CitybuildPlayer cbp = Citybuild.getInstance().getCitybuildPlayer(p.getUniqueId());

        for (Perk perk : Perk.values()) {
            List<String> lore = new ArrayList<>(Arrays.asList(perk.getLore()));
            if (cbp.hasPerk(perk)) {
                lore.add("");
                lore.add("§2§oDu besitzt dieses Item");
            }

            addItem(new ItemBuilder(perk.getMaterial()).displayName(perk.getDisplayname()).lore(lore.toArray(new String[0])).create(), !cbp.hasPerk(perk) ? e -> {
                if (cp.getCoins() - perk.getPrice() >= 0) {
                    cp.removeCoins(perk.getPrice());
                    cbp.addPerk(perk);

                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                } else {
                    Citybuild.getInstance().getMessager().send(p, "§4Du hast nicht genügend Coins!");
                }
            } : null);
        }

        openInventory();
    }
}
