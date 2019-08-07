package eu.mcone.citybuild.plugin.Inventorys.wall;

import com.intellectualcrafters.plot.config.Configuration;
import com.intellectualcrafters.plot.object.Plot;
import eu.mcone.citybuild.plugin.Citybuild;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class WallInventory extends CoreInventory {

    public WallInventory(Player p, Plot plot) {
        super("Bearbeite deine Plot Wand", p, InventorySlot.ROW_3);

        setItem(InventorySlot.ROW_1_SLOT_1, new ItemBuilder(Material.DIAMOND_BLOCK, 1).displayName("§eDirt Wand").lore("§7Für §31000 Coins §7verfügbar!").create(), e -> setWall(plot, p, 1000, "3"));
        setItem(InventorySlot.ROW_1_SLOT_2, new ItemBuilder(Material.IRON_BARS, 1).displayName("§ePrismarine Wand").lore("§7Für §31000 Coins §7verfügbar!").create(), e -> setWall(plot, p, 1000, "168"));
        setItem(InventorySlot.ROW_1_SLOT_3, new ItemBuilder(Material.GLOWSTONE, 1).displayName("§eRedstone Wand").lore("§7Für §31000 Coins §7verfügbar!").create(), e -> setWall(plot, p, 1000, "152"));
        setItem(InventorySlot.ROW_1_SLOT_4, new ItemBuilder(Material.BEACON, 1).displayName("§eEmerald Wand").lore("§7Für §35000 Coins §7verfügbar!").create(), e -> setWall(plot, p, 5000, "133"));
        setItem(InventorySlot.ROW_1_SLOT_5, new ItemBuilder(Material.SEA_LANTERN, 1).displayName("§ePumpkin Rand").lore("§7Für §35000 Coins §7verfügbar!").create(), e -> setWall(plot, p, 5000, "86"));
        setItem(InventorySlot.ROW_1_SLOT_6, new ItemBuilder(Material.END_STONE, 1).displayName("§eEndstone Wand").lore("§7Für §35000 Coins §7verfügbar!").create(), e -> setWall(plot, p, 5000, "121"));
        setItem(InventorySlot.ROW_1_SLOT_7, new ItemBuilder(Material.BEDROCK, 1).displayName("§eSchwamm Wand").lore("§7Für §35000 Coins §7verfügbar!").create(), e -> setWall(plot, p, 5000, "19"));
        setItem(InventorySlot.ROW_1_SLOT_8, new ItemBuilder(Material.CAKE, 1).displayName("§eBedrock Wand").lore("§7Für §310000 Coins §7verfügbar!").create(), e -> setWall(plot, p, 10000, "7"));
        setItem(InventorySlot.ROW_1_SLOT_9, new ItemBuilder(Material.BARRIER, 1).displayName("§eSee Laternen Wand").lore("§7Für §315000 Coins §7verfügbar!").create(), e -> setWall(plot, p, 15000, "169"));
        setItem(InventorySlot.ROW_2_SLOT_1, new ItemBuilder(Material.END_PORTAL_FRAME, 1).displayName("§eMagma Wand").lore("§7Für §320000 Coins §7verfügbar!").create(), e -> setWall(plot, p, 20000, "213"));
        setItem(InventorySlot.ROW_2_SLOT_2, new ItemBuilder(Material.PURPUR_BLOCK, 1).displayName("§ePurpur Wand").lore("§7Für §320000 Coins §7verfügbar!").create(), e -> setWall(plot, p, 20000, "201"));

        setItem(InventorySlot.ROW_3_SLOT_9, new ItemBuilder(Material.QUARTZ_BLOCK, 1).displayName("§eWand zurücksetzen").lore("§7Für §3100 Coins §7verfügbar!").create(), e -> setWall(plot, p, 100, "155"));

        if (p.hasPermission("citybuild.wall.rating")) {
            setItem(InventorySlot.ROW_3_SLOT_5, new ItemBuilder(Material.BEACON, 1).displayName("§4Beacon Wand").lore("§7Eine §3Bewertungwand §7sie gibt es nur wenn das GS schön aussieht!").create(), e -> setWall(plot, p, 0, "138"));

        }

        openInventory();
    }

    private static void setWall(Plot plot, Player p, int price, String blockData) {
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        if ((cp.getCoins() - price) >= 0) {
            cp.removeCoins(price);
            plot.setComponent("wall", Configuration.BLOCKLIST.parseString(blockData));

            Citybuild.getInstance().getMessager().send(p, "§8[§7§l!§8] §fSystem §8» §aDie Wand wurde erfolgreich gesetzt!");
        } else {
            Citybuild.getInstance().getMessager().send(p, "§8[§7§l!§8] §fSystem §8» §cDu hast nicht genügend Coins!");
        }
    }
}
