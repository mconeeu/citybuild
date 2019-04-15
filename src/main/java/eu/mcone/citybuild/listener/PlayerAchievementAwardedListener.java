package eu.mcone.citybuild.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

public class PlayerAchievementAwardedListener implements Listener {

    @EventHandler
    public void on(PlayerAchievementAwardedEvent e) {
        e.setCancelled(true);
    }

}
