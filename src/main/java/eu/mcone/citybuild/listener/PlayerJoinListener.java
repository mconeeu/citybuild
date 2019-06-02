package eu.mcone.citybuild.listener;

import eu.mcone.citybuild.Citybuild;
import eu.mcone.citybuild.player.CitybuildPlayer;
import eu.mcone.citybuild.util.SidebarObjective;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.util.CoreActionBar;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;

public class PlayerJoinListener implements Listener {

    private final static CoreActionBar LOADING_MSG = CoreSystem.getInstance().createActionBar().message("§7§oDeine Daten werden geladen...");
    private final static CoreActionBar LOADING_SUCCESS_MSG = CoreSystem.getInstance().createActionBar().message("§2§oDeine Daten wurden geladen!");

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

        LOADING_MSG.send(p);

        Bukkit.getScheduler().runTask(Citybuild.getInstance(), () -> {
            new CitybuildPlayer(cp);

            cp.getScoreboard().setNewObjective(new SidebarObjective());
            p.getPlayer().playEffect(p.getPlayer().getLocation(), Effect.ENDER_SIGNAL, 10);
            LOADING_SUCCESS_MSG.send(p);
        });
    }
}
