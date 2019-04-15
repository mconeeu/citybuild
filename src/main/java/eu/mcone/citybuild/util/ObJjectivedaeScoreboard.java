package eu.mcone.citybuild.util;

import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreSidebarObjective;
import org.bukkit.Bukkit;

public class ObJjectivedaeScoreboard extends CoreSidebarObjective {

    public ObJjectivedaeScoreboard() {
        super("Citybuild");
    }

    @Override
    protected void onRegister(CorePlayer corePlayer) {

        setDisplayName("§b§nCityBuild");
        setScore(10,"");
        setScore(9,"§7Online Spieler:");
        setScore(8,"§f"+ (Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getServer().getMaxPlayers()));
        setScore(7,"");
        setScore(6, "§7Coins:");
        setScore(5, "§f§o"+ (player.getCoins()));
        setScore(4,"");
        setScore(3,"§7Shop");
        setScore(2,"§fshop.mcone.eu");
        setScore(1,"");
        setScore(0,"§f§lMCONE.EU");



    }

    @Override
    protected void onReload(CorePlayer corePlayer) {

    }
}
