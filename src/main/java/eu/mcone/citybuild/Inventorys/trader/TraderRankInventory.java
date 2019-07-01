/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.Inventorys.trader;

import eu.mcone.citybuild.item.ShopCategory;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;

public class TraderRankInventory extends TraderInventory {

    public TraderRankInventory(Player p) {
        super(ShopCategory.RANK, p);
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);


        addItem(
                new ItemBuilder(Material.GOLDEN_APPLE, 1, 0)
                        .displayName("§c§lDELUXE-RANG")
                        .lore("§7§oKaufe dir hier", "§7§oden DELUXE RANG", "§7§ofür Coins!.")
                        .enchantment(Enchantment.DAMAGE_ALL, 5)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE)
                        .create(),
                e -> p.playSound(p.getLocation(), Sound.NOTE_BASS, 1, 1)
        );

        addItem(
                new ItemBuilder(Material.GOLDEN_APPLE, 1, 0)
                        .displayName("§e§lDELUXE RANG")
                        .lore(
                                "",
                                "§f§oMit diesem EXKLUSIVEN RANG erhälst du",
                                "§f§ofolgende Items:",
                                "",
                                "§6» §7/premium",
                                "§6» §7",
                                "§6» §7",
                                "§6» §7",
                                "§6» §7",
                                "§6» §7",
                                "",
                                "§fKosten: §31.000.000 Coins",
                                "",
                                "§4§lACHTUNG DER RANG GILT NUR FÜR 4 WOCHEN! UND DER RANG GILT NUR AUF CITYBUILD!!"
                        ).create(),
                e -> {
                    if (cp.getCoins() - 1000000 >= 0) {
                        cp.removeCoins(1000000);


                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                        p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast den §eDELUXE-RANG §7erfolgreich gekauft!");
                    } else {
                        p.sendMessage("§8[§7§l!§8] §fSystem §8» §4Du hast nicht genügend Coins");
                    }
                }
        );

        openInventory();
    }
}
