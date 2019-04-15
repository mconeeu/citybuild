package eu.mcone.citybuild.listener;

import eu.mcone.citybuild.util.SidebarObjective;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void on(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        if (p.hasPermission("citybuild.join.vanish")) {
            cp.setVanished(true);
        }

        for (CorePlayer t : CoreSystem.getInstance().getOnlineCorePlayers()) {
            if (t != cp) {
                t.getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
            }
        }

        cp.getScoreboard().setNewObjective(new SidebarObjective());
    }
}
