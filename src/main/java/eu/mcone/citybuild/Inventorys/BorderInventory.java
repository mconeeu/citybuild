package eu.mcone.citybuild.Inventorys;

import com.intellectualcrafters.plot.config.Configuration;
import com.intellectualcrafters.plot.object.Plot;
import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.coresystem.api.bukkit.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class BorderInventory extends CoreInventory {

    public BorderInventory(Player p, Plot plot) {
        super("Bearbeite dein Rand", p, InventorySlot.ROW_3);

        setItem(InventorySlot.ROW_1_SLOT_1, new ItemBuilder(Material.DIAMOND_BLOCK, 1).displayName("§eDiamanten Rand").lore("§7Für §31000 Coins §7verfügbar!").create(), e -> setRand(plot, "57"));
        setItem(InventorySlot.ROW_1_SLOT_2, new ItemBuilder(Material.IRON_BARDING, 1).displayName("§eEisen-Gitter Rand").lore("§7Für §e1000 Coins §7verfügbar!").create(), e -> setRand(plot, "107"));
        setItem(InventorySlot.ROW_1_SLOT_3, new ItemBuilder(Material.GLOWSTONE, 1).displayName("§eGlowstone Rand").lore("§7Für §31000 Coins §7verfügbar!").create(), e -> setRand(plot, "331"));
        setItem(InventorySlot.ROW_1_SLOT_4, new ItemBuilder(Material.BEACON,1).displayName("§eBeacon Rand").lore("§7Für §35000 Coins §7verfügbar!").create(), e -> setRand(plot,"138"));
        setItem(InventorySlot.ROW_1_SLOT_4, new ItemBuilder(Material.SEA_LANTERN,1).displayName("§eSee-Laternen Rand").lore("§7Für §35000 Coins §7verfügbar!").create(), e -> setRand(plot,"169"));
        openInventory();
    }

    private static void setRand(Plot plot, String blockData) {
        plot.setComponent("border", Configuration.BLOCKLIST.parseString(blockData));
    }

}
