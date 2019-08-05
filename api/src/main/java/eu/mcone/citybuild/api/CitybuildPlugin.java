package eu.mcone.citybuild.api;

import eu.mcone.citybuild.api.player.CitybuildPlayer;
import eu.mcone.coresystem.api.bukkit.CorePlugin;
import eu.mcone.coresystem.api.bukkit.config.CoreJsonConfig;
import eu.mcone.coresystem.api.bukkit.player.profile.interfaces.EnderchestManagerGetter;
import eu.mcone.coresystem.api.bukkit.player.profile.interfaces.HomeManagerGetter;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import lombok.Getter;
import org.bukkit.ChatColor;

import java.util.Collection;
import java.util.UUID;

public abstract class CitybuildPlugin extends CorePlugin implements HomeManagerGetter, EnderchestManagerGetter {

    @Getter
    private static CitybuildPlugin instance;

    protected CitybuildPlugin() {
        super("citybuild", ChatColor.AQUA, "citybuild.prefix");
        setInstance(this);
    }

    public abstract CoreJsonConfig getCityBuildConfig();

    public abstract CoreWorld getPlotWorld();

    public abstract CoreWorld getFarmWorld();

    public abstract CoreWorld getNether();

    public abstract void registerCitybuildPlayer(CitybuildPlayer lp);

    public abstract void unregisterCitybuildPlayer(CitybuildPlayer lp);

    public abstract CitybuildPlayer getCitybuildPlayer(UUID uuid);

    public abstract CitybuildPlayer getCitybuildPlayer(String name);

    public abstract Collection<CitybuildPlayer> getCitybuildPlayers();

    public abstract void unsetWorlds();

    private static void setInstance(CitybuildPlugin plugin) {
        if (instance == null) {
            instance = plugin;
        } else {
            throw new UnsupportedOperationException("CitybuildPlugin instance is already created!");
        }
    }
}
