/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class PlayerDamageListener implements Listener {

    @EventHandler
    public void on(EntityDamageEvent e) {

        if(e.getCause().equals(EntityDamageEvent.DamageCause.FALL) && e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (p.hasPermission("citybuild.perks.falldamage")) {
                e.setCancelled(true);
            }
        }
    }

}

