package eu.mcone.citybuild.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherChangeListener implements Listener {

    @EventHandler
    public void on(WeatherChangeEvent e) {
        if (e.toWeatherState())
            e.setCancelled(true);
    }

}
