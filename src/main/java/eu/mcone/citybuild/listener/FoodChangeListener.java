/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.listener;

import eu.mcone.citybuild.Citybuild;
import eu.mcone.citybuild.item.Perk;
import eu.mcone.citybuild.player.CitybuildPlayer;
import eu.mcone.coresystem.api.bukkit.event.MoneyChangeEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.scoreboard.DisplaySlot;

public class FoodChangeListener implements Listener {

    @EventHandler
    public void on(FoodLevelChangeEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();

            CitybuildPlayer cbp = Citybuild.getInstance().getCitybuildPlayer(p.getUniqueId());

            if (cbp.hasPerk(Perk.FOOD_SAVE)) {
                e.setCancelled(true);
            }
        }

    }

}
