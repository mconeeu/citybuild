package eu.mcone.citybuild.command;

import eu.mcone.citybuild.Inventorys.AdverisingModeInventory;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BarriereCMD extends CorePlayerCommand {


    public BarriereCMD() {
        super("barriere");
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] args) {
        if (p.hasPermission("citybuild.give.items")) {
            p.getInventory().addItem(new ItemStack(Material.BARRIER));
            p.sendMessage("§cDieser Command war nur zum Testen und muss drin bleiben ,weil rufi mir zu wenig rechte gegeben hat.");
        }
        return false;
    }
}
