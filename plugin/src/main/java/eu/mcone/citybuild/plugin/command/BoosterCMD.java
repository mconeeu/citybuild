package eu.mcone.citybuild.plugin.command;

import eu.mcone.citybuild.plugin.Inventorys.booster.BoosterInventory;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;

import org.bukkit.entity.Player;

public class BoosterCMD extends CorePlayerCommand {


    public BoosterCMD() {
        super("booster"); }

    @Override
    public boolean onPlayerCommand(Player p, String[] args) {

      new BoosterInventory(p);

        return false;
    }
}