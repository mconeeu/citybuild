/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.listener;

import com.intellectualcrafters.plot.object.PlotPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class PlayerToggleFlightListener implements Listener {

    @EventHandler
    public void on(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();
        PlotPlayer pp = PlotPlayer.wrap(p);

        if (!pp.getCurrentPlot().isAdded(p.getUniqueId()) && !p.hasPermission("system.bukkit.fly")) {
            e.setCancelled(true);
        }
    }

}
