/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.plugin.listener;

import eu.mcone.citybuild.plugin.Citybuild;
import eu.mcone.citybuild.api.item.Perk;
import eu.mcone.citybuild.api.player.CitybuildPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodChangeListener implements Listener {

    @EventHandler
    public void on(FoodLevelChangeEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();

            CitybuildPlayer cbp = Citybuild.getInstance().getCitybuildPlayer(p.getUniqueId());

            if (cbp.hasPerk(Perk.FOOD_SAVE)
                    && cbp.isPerkActivated(Perk.FOOD_SAVE)) {
                e.setCancelled(true);
            }
        }
    }
}
