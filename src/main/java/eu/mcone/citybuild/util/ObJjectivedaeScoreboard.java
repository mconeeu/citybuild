package eu.mcone.citybuild.util;

import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreSidebarObjective;

public class ObJjectivedaeScoreboard extends CoreSidebarObjective {

    public ObJjectivedaeScoreboard() {
        super("Citybuild");
    }

    @Override
    protected void onRegister(CorePlayer corePlayer) {

        setDisplayName("33CityBuild");
        setScore(7,"");
        setScore(6,"");
        setScore(5,"");
        setScore(4, "§7Coins:");
        setScore(3, "§o"+ (player.getCoins()));
        setScore(2,"");
        setScore(1,"");



    }

    @Override
    protected void onReload(CorePlayer corePlayer) {

    }
}
