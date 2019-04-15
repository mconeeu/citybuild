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
        setItem(InventorySlot.ROW_1_SLOT_2, new ItemBuilder(Material.IRON_FENCE, 1).displayName("§eEisen-Gitter Rand").lore("§7Für §e1000 Coins §7verfügbar!").create(), e -> setRand(plot, "101"));
        setItem(InventorySlot.ROW_1_SLOT_3, new ItemBuilder(Material.GLOWSTONE, 1).displayName("§eGlowstone Rand").lore("§7Für §31000 Coins §7verfügbar!").create(), e -> setRand(plot, "89"));
        setItem(InventorySlot.ROW_1_SLOT_4, new ItemBuilder(Material.BEACON,1).displayName("§eBeacon Rand").lore("§7Für §35000 Coins §7verfügbar!").create(), e -> setRand(plot,"138"));
        setItem(InventorySlot.ROW_1_SLOT_5, new ItemBuilder(Material.SEA_LANTERN,1).displayName("§eSee-Laternen Rand").lore("§7Für §35000 Coins §7verfügbar!").create(), e -> setRand(plot,"169"));
        setItem(InventorySlot.ROW_1_SLOT_6, new ItemBuilder(Material.ENDER_STONE,1).displayName("§eEndstone Rand").lore("§7Für §35000 Coins §7verfügbar!").create(), e -> setRand(plot,"121"));
        setItem(InventorySlot.ROW_1_SLOT_7, new ItemBuilder(Material.BEDROCK,1).displayName("§eBedrock Rand").lore("§7Für §35000 Coins §7verfügbar!").create(), e -> setRand(plot,"7"));
        setItem(InventorySlot.ROW_1_SLOT_8, new ItemBuilder(Material.CAKE_BLOCK,1).displayName("§eKuchen Rand").lore("§7Für §310000 Coins §7verfügbar!").create(), e -> setRand(plot,"92"));

        openInventory();
    }

    private static void setRand(Plot plot, String blockData) {
        plot.setComponent("border", Configuration.BLOCKLIST.parseString(blockData));
    }

}
