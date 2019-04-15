package eu.mcone.citybuild.command;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;

public class PayCMD extends CorePlayerCommand {

    public PayCMD() {
        super("pay");
    }

    @Override
    public boolean onPlayerCommand(Player bp, String[] args) {
        if (args.length == 2) {
            CorePlayer p = CoreSystem.getInstance().getCorePlayer(bp);
            int amount = Integer.parseInt(args[1]);

            if (args[0].equals("*")) {
                if (p.getCoins() - (amount * Bukkit.getOnlinePlayers().size()) >= 0) {
                    for (CorePlayer t : CoreSystem.getInstance().getOnlineCorePlayers()) {
                        if (t != p) {
                            t.addCoins(amount);
                            p.removeCoins(amount);

                            t.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast §e" + amount + " §6Coins §avon §e" + p.getName() + "§a bekommen!");
                        }
                    }

                    p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast §eallen Spielern §aerfolgreich §e" + amount + "§a Coins gegeben!");
                } else {
                    p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast nicht genügend §eCoins§c.");
                }
            } else {
                CorePlayer t = CoreSystem.getInstance().getCorePlayer(args[0]);

                if (t != null) {
                    if (p != t) {
                        if ((p.getCoins() - amount) >= 0) {
                            p.removeCoins(amount);
                            t.addCoins(amount);

                            p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast §e" + t.getName() + " §aerfolgreich §e" + amount + "§a Coins gegeben!");
                            t.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast §e" + amount + " §6Coins §avon §e" + p.getName() + "§a bekommen!");
                        } else {
                            p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast nicht genügend §eCoins§c.");
                        }
                    } else {
                        p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du kannst dir nicht selbs Coins zahlen, Dummkopf.");
                    }
                } else {
                    p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Der Spieler ist nicht §aOnline§c.");
                    {

                    }
                }
            }
        } else {
            bp.sendMessage("§8[§7§l!§8] §fSystem §8» §4Bitte benutze: §c/pay <Spieler> <Anzahl>");
        }
        return false;
    }
}
