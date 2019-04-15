package eu.mcone.citybuild.listener;

import eu.mcone.citybuild.Citybuild;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener implements Listener {

    @EventHandler
    public void on(PlayerRespawnEvent e) {
        e.setRespawnLocation(Citybuild.getInstance().getPlotWorld().getLocation("spawn"));
    }

}
