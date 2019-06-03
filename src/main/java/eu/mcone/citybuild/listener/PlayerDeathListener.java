package eu.mcone.citybuild.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void on(PlayerDeathEvent e) {
        e.setDeathMessage(null);
        Player p = e.getEntity();

        if(p.hasPermission("citybuild.perks.keepinventory")) {
            e.setKeepInventory(true);
        }
    }

}
