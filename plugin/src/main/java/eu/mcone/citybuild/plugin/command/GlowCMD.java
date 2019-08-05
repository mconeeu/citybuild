package eu.mcone.citybuild.plugin.command;

import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import org.bukkit.entity.Player;

public class GlowCMD extends CorePlayerCommand {


    public GlowCMD() {
        super("glow");
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] args) {

        if (p.hasPermission("citybuild.glowing")) {
            if (p.isGlowing()) {
                p.setGlowing(false);
                p.sendMessage("§8[§7§l!§8] §fServer §8» §cDu leuchtest nun nicht mehr");
            } else {
                p.setGlowing(true);
                p.sendMessage("§8[§7§l!§8] §fServer §8» §aDu leuchtest nun!");
            }
        } else {
            p.sendMessage("§8[§7§l!§8] §fServer §8» §4Du hast keine Rechte für diesen Befehl!");
        }



        return false;
    }
}
