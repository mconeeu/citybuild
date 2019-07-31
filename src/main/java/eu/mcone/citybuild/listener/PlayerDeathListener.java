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
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void on(PlayerDeathEvent e) {
        e.setDeathMessage(null);
        Player p = e.getEntity();
        CitybuildPlayer cbp = Citybuild.getInstance().getCitybuildPlayer(p.getUniqueId());

        if (cbp.hasPerk(Perk.KEEP_INVENTORY_ON_DEATH)) {
            e.setKeepInventory(true);
        }

        if (cbp.hasPerk(Perk.KEEP_XP_ON_DEATH)) {
            e.setKeepLevel(true);


        }

    }

}
