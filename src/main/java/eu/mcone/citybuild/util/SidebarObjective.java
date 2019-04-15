package eu.mcone.citybuild.util;

import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreSidebarObjective;
import org.bukkit.Bukkit;

public class SidebarObjective extends CoreSidebarObjective {

    public SidebarObjective() {
        super("Citybuild");
    }

    @Override
    protected void onRegister(CorePlayer player) {

        setDisplayName("§7§l⚔ §b§l§nCitybuild");
        setScore(10, "");
        setScore(9, "§8» §7Online Spieler:");
        setScore(8, " §f"+ Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getServer().getMaxPlayers());
        setScore(7, "");
        setScore(6, "§8» §7Coins:");
        setScore(5, " §a"+ player.getFormattedCoins());
        setScore(4, "");
        setScore(3, "§8» §7Shop:");
        setScore(2, " §bshop.mcone.eu");
        setScore(1, "");
        setScore(0, "§f§lMCONE.EU");
    }

    @Override
    protected void onReload(CorePlayer corePlayer) {
        setScore(8, " §f"+ Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getServer().getMaxPlayers());
        setScore(5, " §a"+ player.getFormattedCoins());
    }
}
