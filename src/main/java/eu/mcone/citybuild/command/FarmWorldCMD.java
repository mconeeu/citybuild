package eu.mcone.citybuild.command;

import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FarmWorldCMD extends CorePlayerCommand {

    public FarmWorldCMD() { super("farmwerlt");
    }


    @Override
    public boolean onPlayerCommand(Player p, String[] strings) {

        p.teleport(Bukkit.getWorld("Farmwelt").getSpawnLocation());

        return false;


    }
}
