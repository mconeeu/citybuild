/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.plugin.listener;

import eu.mcone.coresystem.api.bukkit.event.MoneyChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;

public class MoneyChangeListener implements Listener {

    @EventHandler
    public void on(MoneyChangeEvent e) {
        e.getPlayer().getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
    }

}
