package eu.mcone.citybuild.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

public class PlayerChatListener implements Listener {

    @EventHandler
    public void on(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if (p.hasPermission("citybuild.chat.color")) {

            e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));

        }

    }
}
