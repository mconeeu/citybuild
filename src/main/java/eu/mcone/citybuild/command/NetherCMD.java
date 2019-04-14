package eu.mcone.citybuild.command;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class NetherCMD extends CorePlayerCommand {

    public NetherCMD() {
        super("Nether");
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] strings) {

        p.teleport(Bukkit.getWorld("Nether").getSpawnLocation());


        return false;
    }
}
