package eu.mcone.citybuild.util;


import eu.mcone.citybuild.Citybuild;
import org.bukkit.Bukkit;

public class Broadcast {

    private static int i = 0;

    public static void schedule() {
        Bukkit.getScheduler().runTaskTimer(Citybuild.getInstance(), () -> {
            switch (i) {
                case 0: {
                    Bukkit.getServer().broadcastMessage("§r\n§8[§7§l!§8] §bCitybuild §8» §f§nDu brauchst Werbung§r§f für Deinen Shop oder dein Event?\n§8[§7§l!§8] §bCitybuild §8» §fDann benutze §n/werbung§r§f!\n§r");
                    break;
                }
                case 1: {
                    Bukkit.getServer().broadcastMessage("§r\n§8[§7§l!§8] §bCitybuild §8» §fDu suchst §nSpezielle Items§r§f?\n§8[§7§l!§8] §bCitybuild §8» §fDann besuche doch mal den §nCityBuild Händler§r§f am Spawn\n§r");
                    i = -1;
                    break;
                }
            }
            i++;
        }, 0, 190 * 20);
    }
}
