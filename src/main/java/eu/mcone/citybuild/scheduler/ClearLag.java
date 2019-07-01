/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.scheduler;

import eu.mcone.citybuild.Citybuild;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class ClearLag implements Runnable {

    @Override
    public void run() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            Citybuild.getInstance().getMessager().send(p, "§cIn einer Minute werden alle gedroppten Items gelöscht!");
        }

        Bukkit.getScheduler().runTaskLaterAsynchronously(Citybuild.getInstance(), () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                Citybuild.getInstance().getMessager().send(p, "§cIn 10 Sekunden werden alle gedroppten Items gelöscht!");
            }

            Bukkit.getScheduler().runTaskLater(Citybuild.getInstance(), () -> {
                for (Entity e : Citybuild.getInstance().getPlotWorld().bukkit().getEntities()) {
                    if (e.getType().equals(EntityType.DROPPED_ITEM) || e.getType().equals(EntityType.MINECART) || e.getType().equals(EntityType.BOAT) || e.getType().equals(EntityType.EXPERIENCE_ORB)) {
                        e.remove();
                    }
                }

                for (Player p : Bukkit.getOnlinePlayers()) {
                    Citybuild.getInstance().getMessager().send(p, "§cAlle gedroppten Items wurden gelöscht!");
                }
            }, 10 * 20);
        }, 50 * 20);
    }
}
