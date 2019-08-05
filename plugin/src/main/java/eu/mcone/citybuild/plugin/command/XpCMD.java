package eu.mcone.citybuild.plugin.command;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.command.CoreCommand;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class XpCMD extends CoreCommand {


    public XpCMD() {
        super("level", null, "xp");
    }

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {
        if (args.length == 0 && sender instanceof Player) {
            Player p = (Player) sender;

            p.sendMessage("§8[§7§l!§8] §dLevel §8» §7Du hast momentan §d" + p.getLevel() + " Level§7!");

            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 1);
        } else if (sender.hasPermission("citybuild.xp")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("remove")) {
                    CoreSystem.getInstance().getMessager().send(sender, "§4Bitte benutze: §c/xp oder /level <add | remove> <name> <amount> §4oder §c/xp oder /level <name>");
                    return true;
                } else {
                    Player t = Bukkit.getPlayer(args[0]);

                    if (t != null) {
                        sender.sendMessage("§8[§7§l!§8] §dLevel §8» §7Der Spieler §f" + t.getName() + " §7hat §d" + t.getLevel() + " Level§7!");
                    } else {
                        sender.sendMessage("§8[§7§l!§8] §dLevel §8» §cDer Spieler ist nicht online!");
                    }
                    return true;
                }
            } else if (args.length == 3) {
                if (args[0].equalsIgnoreCase("add")) {
                    Player t = Bukkit.getPlayer(args[1]);

                    if (t != null) {
                        t.setLevel(Integer.valueOf(args[2]));
                        sender.sendMessage("§8[§7§l!§8] §dLevel §8» §7Du hast §f" + t.getName() + " §7erfolgreich §d" + args[2] + " Level§7 hinzugefügt");
                    } else {
                        sender.sendMessage("§8[§7§l!§8] §dLevel §8» §cDer Spieler ist nicht online!");
                    }
                    return true;
                } else if (args[0].equalsIgnoreCase("remove")) {
                    Player t = Bukkit.getPlayer(args[1]);

                    if (t != null) {
                        int current = t.getLevel();
                        int amount = Integer.valueOf(args[2]);

                        if ((current - amount) >= 0) {
                            t.setLevel(current - amount);
                            sender.sendMessage("§8[§7§l!§8] §dLevel §8» §7Du hast §f" + t.getName() + " §7erfolgreich §f" + args[2] + " §7Level entfernt");
                        } else {
                            sender.sendMessage("§8[§7§l!§8] §dLevel §8» §7Du kannst §f" + t.getName() + " §7nicht so viele Level entfernen! Er hat nur §d" + current + " §dLevel§7!");
                        }
                    } else {
                        sender.sendMessage("§8[§7§l!§8] §dLevel §8»§c Der Spieler ist nicht online!");
                    }
                    return true;
                }
            }

            CoreSystem.getInstance().getMessager().send(sender, "4Bitte benutze: §c/xp oder /level <add | remove> <name> <amount> §4oder §c/xp oder /level <name>");
        } else if (sender instanceof Player) {
            CoreSystem.getInstance().getMessager().sendTransl((Player) sender, "system.command.noperm");
        }

        return true;
    }

}

