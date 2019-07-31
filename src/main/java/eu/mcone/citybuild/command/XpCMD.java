package eu.mcone.citybuild.command;

import eu.mcone.coresystem.api.bukkit.command.CoreCommand;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class XpCMD extends CorePlayerCommand {


    public XpCMD() {
        super("xp");
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] args) {

        if (p.hasPermission("citybuild.see.xp")) {
            if (args.length == 1) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    p.sendMessage("§8[§7§l!§8] §fServer §8» §aDer Spieler §c" + args[0] + "§7hat momentan §5" + t.getLevel() + "§5Level!");
                } else {
                    p.sendMessage("§8[§7§l!§8] §fServer §8» §cDieser Spieler ist nicht Online!");

                }
            } else {
                p.sendMessage("§8[§7§l!§8] §fServer §8» §aBitte benutze /xp <Spieler>");
            }
        } else {
            p.sendMessage("§8[§7§l!§8] §fServer §8» §4Du hast keine Rechte für diesen Befehl!");
        }


        return false;
    }
}

