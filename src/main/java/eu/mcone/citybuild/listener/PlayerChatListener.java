/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.listener;

import eu.mcone.citybuild.Citybuild;
import eu.mcone.citybuild.util.CitybuildChatColor;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void on(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        ChatColor color = Citybuild.getInstance().getCitybuildPlayer(p.getUniqueId()).getDefaultChatColor();
        if (color != null) {
            e.setMessage(color + e.getMessage());
        }

        if (p.hasPermission("citybuild.chat.color")) {
            for (ChatColor c : ChatColor.values()) {
                if (c.isColor()) {
                    e.setMessage(e.getMessage().replace("&"+c.getChar(), "§"+c.getChar()));
                }
            }
        }
    }
}
