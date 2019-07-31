/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.listener;

import eu.mcone.citybuild.Citybuild;
import eu.mcone.citybuild.item.Perk;
import eu.mcone.citybuild.player.CitybuildPlayer;
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

        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            CitybuildPlayer cbp = Citybuild.getInstance().getCitybuildPlayer(p.getUniqueId());

            if (cbp.hasPerk(Perk.NO_FALL_DAMAGE)) {
                if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL) && e.getEntity() instanceof Player) {
                    e.setCancelled(true);
                }
            }
        }
    }

}

