package eu.mcone.citybuild.listener;


import eu.mcone.citybuild.Citybuild;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import org.bukkit.Bukkit;

public class Broadcast {

    private static int i = 0;

    public static void schedule() {
        Bukkit.getScheduler().runTaskTimer(Citybuild.getInstance(), () -> {
            switch (i) {
                case 0: {
                    Bukkit.getServer().broadcastMessage("§c\n§8[§7§l!§8] §fDu brauchst Werbung für dein Shop oder dein Event\n§8[§7§l!§8] §fDann benutze /Werbung\n§r");
                    break;
                }
                case 1: {
                    Bukkit.getServer().broadcastMessage("§c\n§8[§7§l!§8] §fDu suchst Spezielle Items\n§8[§7§l!§8] §fDann besuche doch mal den CityBuild Händler am Spawn\n§r");
                    i = -1;
                    break;
                }
            }
            i++;
        }, 0, 190 * 20);
    }
}
