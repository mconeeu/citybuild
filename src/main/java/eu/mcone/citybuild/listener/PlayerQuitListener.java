package eu.mcone.citybuild.listener;

import eu.mcone.citybuild.Citybuild;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void on(PlayerQuitEvent e) {
        Bukkit.getScheduler().runTask(Citybuild.getInstance(), () -> {
            for (CorePlayer t : CoreSystem.getInstance().getOnlineCorePlayers()) {
                if (!t.getUuid().equals(e.getPlayer().getUniqueId())) {
                    t.getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
                }
            }
        });
    }

}
