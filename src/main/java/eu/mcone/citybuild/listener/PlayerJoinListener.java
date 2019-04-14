package eu.mcone.citybuild.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void on(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        if (p.hasPermission("citybuild.join.vanish")) {

            cp.setVanished(true);
            p.sendMessage("§8[§7§l!§8] §fSystem §8» §aDu bist nun im Vanish!");
        }

    }
}
