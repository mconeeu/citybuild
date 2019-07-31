/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.Inventorys.border;

import com.intellectualcrafters.plot.config.Configuration;
import com.intellectualcrafters.plot.object.Plot;
import eu.mcone.citybuild.Citybuild;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;

public class BorderInventory extends CoreInventory {

    public BorderInventory(Player p, Plot plot) {
        super("Bearbeite dein Rand", p, InventorySlot.ROW_3);

        setItem(InventorySlot.ROW_1_SLOT_1, new ItemBuilder(Material.DIAMOND_BLOCK, 1).displayName("§eDiamanten Rand").lore("§7Für §31000 Coins §7verfügbar!").create(), e -> setRand(plot, p, 1000, "57"));
        setItem(InventorySlot.ROW_1_SLOT_2, new ItemBuilder(Material.IRON_BARS, 1).displayName("§eEisen-Gitter Rand").lore("§7Für §31000 Coins §7verfügbar!").create(), e -> setRand(plot, p, 1000, "101"));
        setItem(InventorySlot.ROW_1_SLOT_3, new ItemBuilder(Material.GLOWSTONE, 1).displayName("§eGlowstone Rand").lore("§7Für §31000 Coins §7verfügbar!").create(), e -> setRand(plot, p, 1000, "89"));
        setItem(InventorySlot.ROW_1_SLOT_4, new ItemBuilder(Material.BEACON, 1).displayName("§eBeacon Rand").lore("§7Für §35000 Coins §7verfügbar!").create(), e -> setRand(plot, p, 5000, "138"));
        setItem(InventorySlot.ROW_1_SLOT_5, new ItemBuilder(Material.SEA_LANTERN, 1).displayName("§eSee-Laternen Rand").lore("§7Für §35000 Coins §7verfügbar!").create(), e -> setRand(plot, p, 5000, "169"));
        setItem(InventorySlot.ROW_1_SLOT_6, new ItemBuilder(Material.END_STONE, 1).displayName("§eEndstone Rand").lore("§7Für §35000 Coins §7verfügbar!").create(), e -> setRand(plot, p, 5000, "121"));
        setItem(InventorySlot.ROW_1_SLOT_7, new ItemBuilder(Material.BEDROCK, 1).displayName("§eBedrock Rand").lore("§7Für §35000 Coins §7verfügbar!").create(), e -> setRand(plot, p, 5000, "7"));
        setItem(InventorySlot.ROW_1_SLOT_8, new ItemBuilder(Material.CAKE, 1).displayName("§eKuchen Rand").lore("§7Für §310000 Coins §7verfügbar!").create(), e -> setRand(plot, p, 10000, "92"));
        setItem(InventorySlot.ROW_1_SLOT_9, new ItemBuilder(Material.BARRIER, 1).displayName("§eKein Rand").lore("§7Für §315000 Coins §7verfügbar!").create(), e -> setRand(plot, p, 15000, "0"));
        setItem(InventorySlot.ROW_2_SLOT_1, new ItemBuilder(Material.END_PORTAL_FRAME, 1).displayName("§eEndportal Rand").lore("§7Für §320000 Coins §7verfügbar!").create(), e -> setRand(plot, p, 20000, "120"));
        setItem(InventorySlot.ROW_2_SLOT_2, new ItemBuilder(Material.NOTE_BLOCK, 1).displayName("§eNoteblock Rand").lore("§7Für §320000 Coins §7verfügbar!").create(), e -> setRand(plot, p, 20000, "25"));

        setItem(InventorySlot.ROW_3_SLOT_9, new ItemBuilder(Material.SANDSTONE_SLAB, 1).displayName("§eRand zurücksetzen").lore("§7Für §3100 Coins §7verfügbar!").create(), e -> setRand(plot, p, 100, "44:1"));

        if (p.hasPermission("citybuild.border.rating")) {
            setItem(InventorySlot.ROW_3_SLOT_5, new ItemBuilder(Material.DRAGON_EGG, 1).displayName("§4Drachenei Rand").lore("§7Ein §3BEWERTUNGSRAND §7gibt es nur wenn das GS schön aussieht!").create(), e -> setRand(plot, p, 0, "122"));

        }

        openInventory();
    }

    private static void setRand(Plot plot, Player p, int price, String blockData) {
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        if ((cp.getCoins() - price) >= 0) {
            cp.removeCoins(price);
            plot.setComponent("border", Configuration.BLOCKLIST.parseString(blockData));

            Citybuild.getInstance().getMessager().send(p, "§8[§7§l!§8] §fSystem §8» §aDer Rand wurde erfolgreich gesetzt!");
        } else {
            Citybuild.getInstance().getMessager().send(p, "§8[§7§l!§8] §fSystem §8» §7Du hast nicht genügend Coins!");
        }
    }

}
