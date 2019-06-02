package eu.mcone.citybuild.command;

import eu.mcone.citybuild.Inventorys.AdverisingModeInventory;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import org.bukkit.entity.Player;

public class AdvertisingCMD extends CorePlayerCommand {

    public AdvertisingCMD() {
        super("werbung");
        CoreSystem.getInstance().getCooldownSystem().setCustomCooldownFor(getClass(), 190);
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] args) {
        new AdverisingModeInventory(p);
        return true;
    }
}
