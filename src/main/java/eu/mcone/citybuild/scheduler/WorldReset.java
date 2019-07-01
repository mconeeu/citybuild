/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.scheduler;

import eu.mcone.citybuild.Citybuild;
import eu.mcone.citybuild.player.CitybuildPlayer;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.util.CoreTitle;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.*;

public class WorldReset implements Runnable {

    private static final long RESET_TIME = 4 * 24 * 60 * 60;
    private static final CoreTitle RESET_INFO = CoreSystem.getInstance().createTitle().title("§c§lFarmwelt & Nether§4 Reset").subTitle("§4§oReset der Farmwelt und des Nethers in 10min!").stay(5);

    @Getter
    private static long lastReset = Citybuild.getInstance().getCitybuildConfig().getJson().getAsJsonObject().get("lastReset").getAsLong();

    @Override
    public void run() {
        if (Citybuild.getInstance().getCitybuildConfig().getJson().getAsJsonObject().get("lastReset").getAsLong() < ((System.currentTimeMillis() / 1000) - RESET_TIME)) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                RESET_INFO.send(p);

                p.sendMessage("§r");
                Citybuild.getInstance().getMessager().send(p, "§4Die §cFarmwelten§4 werden in 10 Minuten §c§nzurückgesetzt§4!\n§r");
            }

            Bukkit.getScheduler().runTaskLaterAsynchronously(Citybuild.getInstance(), () -> {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.sendMessage("§r");
                    Citybuild.getInstance().getMessager().send(p, "§4Die §cFarmwelten§4 werden in 10 Sekunden §c§nzurückgesetzt§4!\n§r");
                }

                CoreWorld farmWorld = Citybuild.getInstance().getFarmWorld();
                CoreWorld nether = Citybuild.getInstance().getNether();
                Citybuild.getInstance().unsetWorlds();

                Bukkit.getScheduler().runTaskLater(Citybuild.getInstance(), () -> {
                    //Delete worlds
                    farmWorld.delete();
                    nether.delete();

                    for (Player p : Bukkit.getOnlinePlayers()) {
                        p.kickPlayer("Der Server ist gleich wieder online! Die Farmwelten werden zurückgesetzt...");
                    }

                    Bukkit.getScheduler().runTaskLater(Citybuild.getInstance(), () -> {
                        setLastReset(System.currentTimeMillis() / 1000);
                        Bukkit.shutdown();
                    }, 20 * 3);
                }, 10 * 20);
            }, 10 * 60 * 20);
        }

    }

    public static void resetHomes(CitybuildPlayer cbp) {
        List<String> deleteHomes = new ArrayList<>();
        World farmworld = Citybuild.getInstance().getFarmWorld().bukkit();
        World nether = Citybuild.getInstance().getNether().bukkit();

        for (Map.Entry<String, Location> home : cbp.getHomes().entrySet()) {
            if (home.getValue().getWorld().equals(farmworld) || home.getValue().getWorld().equals(nether)) {
                deleteHomes.add(home.getKey());
            }
        }

        for (String home : deleteHomes) {
            cbp.removeHome(home);
        }

        Citybuild.getInstance().getMessager().send(cbp.bukkit(), "§7Deine Homes in Farmwelt und Nether wurden wegen dem neuesten World-Reset gelöscht!");
    }

    private static void setLastReset(long lastReset) {
        WorldReset.lastReset = lastReset;

        Citybuild.getInstance().getCitybuildConfig().getJson().getAsJsonObject().addProperty("lastReset", lastReset);
        Citybuild.getInstance().getCitybuildConfig().save();
    }

    public static long getNextReset() {
        return lastReset + RESET_TIME;
    }

}
