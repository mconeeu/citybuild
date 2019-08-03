package eu.mcone.citybuild.command;

import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BroadcastCMD extends CorePlayerCommand {

    public BroadcastCMD() {
        super("broadcast");
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] args) {
        if (p.hasPermission("citybuild.broadcast")) {
            if (args.length > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i <= args.length; i++) {
                    stringBuilder.append(args[i]);
                }

                Bukkit.getServer().broadcastMessage("§8[§7§l!§8] §5Rundruf §8» §c" + stringBuilder.toString());
            } else {
                p.sendMessage("§8[§7§l!§8] §fServer §8» §cBitte benutze /broadcast <Nachricht>");
            }
        } else {
            p.sendMessage("§8[§7§l!§8] §fServer §8» §4Du hast keine Rechte für diesen Befehl!");
        }
        return true;
    }
}
