package eu.mcone.citybuild.listener;

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
