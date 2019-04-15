package eu.mcone.citybuild.command;

import eu.mcone.citybuild.Inventorys.AdverisingModeInventory;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class CraftCMD extends CorePlayerCommand {

    public CraftCMD() {
        super("craft");
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] args) {

        if (p.hasPermission("craft.use")) {
            p.openWorkbench(null, true);
            p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1, 1);
            return true;
        } else {
            p.sendMessage("Du hast keine Rechte dafür!");
        }
        return false;
    }
}
