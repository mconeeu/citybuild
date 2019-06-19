package eu.mcone.citybuild.command;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.command.CoreCommand;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpecCMD extends CorePlayerCommand {

    public SpecCMD() {
        super("spec");
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] args) {
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);


        if (p.getGameMode() == GameMode.SPECTATOR && cp.isVanished()) {
            p.setGameMode(GameMode.SURVIVAL);
            p.sendMessage("§8[§7§l!§8] §fServer §8» §7Du hörst nun auf einen Spieler zu beobachten, bist aber weiterhin im Vanish!");
            p.teleport(Bukkit.getWorld("plots").getSpawnLocation());


        } else if (p.hasPermission("citybuild.spec")) {
            if (args.length == 1) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    if (t != p) {
                        p.setGameMode(GameMode.SPECTATOR);
                        if (cp.isVanished()) {
                        p.teleport(t);
                        p.sendMessage("§8[§7§l!§8] §fServer §8» §aDu beobachtest nun§f " + t.getDisplayName() + "§a um den Modus zu verlassen §f/spec§a!");
                        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);

                        } else {
                            cp.setVanished(true);
                            p.teleport(t);
                            p.sendMessage("§8[§7§l!§8] §fServer §8» §aDu beobachtest nun§f " + t.getDisplayName() + "§a um den Modus zu verlassen §f/spec§a!");
                            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
                        }
                    } else {
                        p.sendMessage("§8[§7§l!§8] §fSystem §8» §4Du kannst dich nicht selbst beaobachten!");
                    }
                } else {
                    p.sendMessage("§8[§7§l!§8] §fSystem §8» §4Der Spieler ist nicht Online");
                }
            } else {
                p.sendMessage("§8[§7§l!§8] §fServer §8» §cBitte benutze /spec <Spieler>");
            }
        } else {
            p.sendMessage("§8[§7§l!§8] §fServer §8» §4Du hast keine Rechte für diesen Befehl!");
        }


        return false;
    }
}


