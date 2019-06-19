package eu.mcone.citybuild.Inventorys;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Flying;
import org.bukkit.entity.Player;

public class BoosterInventory extends CoreInventory {

    public BoosterInventory(Player p) {
        super("§f§lDeine Booster", p, InventorySlot.ROW_3, Option.FILL_EMPTY_SLOTS);





       openInventory();
    }
}
