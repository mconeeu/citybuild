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
        super("Rand setzen", p, InventorySlot.ROW_4);

        setItem(InventorySlot.ROW_1_SLOT_1, new ItemBuilder(Material.SANDSTONE_STAIRS, 1).displayName("Rand zurücksetzen").create(), e -> setRand(plot, "44:1"));
        setItem(InventorySlot.ROW_1_SLOT_2, new ItemBuilder(Material.BEACON, 1).displayName("Beacon setzen").create(), e -> setRand(plot, "138"));

        openInventory();
    }

    private static void setRand(Plot plot, String blockData) {
        plot.setComponent("border", Configuration.BLOCKLIST.parseString(blockData));
    }

}
