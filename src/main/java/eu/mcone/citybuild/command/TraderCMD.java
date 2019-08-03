package eu.mcone.citybuild.command;

import eu.mcone.citybuild.Inventorys.trader.TraderInventory;
import eu.mcone.citybuild.Inventorys.trader.TraderSurvivalInventory;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import org.bukkit.entity.Player;

public class TraderCMD extends CorePlayerCommand {


    public TraderCMD() {
        super("händler");
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] args) {

        new TraderSurvivalInventory(p);

        return false;
    }
}
