package eu.mcone.citybuild;

import eu.mcone.citybuild.command.*;
import eu.mcone.citybuild.listener.*;
import eu.mcone.citybuild.player.CitybuildPlayer;
import eu.mcone.citybuild.util.Broadcast;
import eu.mcone.citybuild.util.SidebarObjective;
import eu.mcone.coresystem.api.bukkit.CorePlugin;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.profile.interfaces.EnderchestManager;
import eu.mcone.coresystem.api.bukkit.player.profile.interfaces.EnderchestManagerGetter;
import eu.mcone.coresystem.api.bukkit.player.profile.interfaces.HomeManager;
import eu.mcone.coresystem.api.bukkit.player.profile.interfaces.HomeManagerGetter;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class Citybuild extends CorePlugin implements HomeManagerGetter, EnderchestManagerGetter {

    @Getter
    private static Citybuild instance;

    @Getter
    private CoreWorld plotWorld;
    private List<CitybuildPlayer> players;

    public Citybuild() {
        super("citybuild", ChatColor.AQUA, "citybuild.prefix");
    }

    @Override
    public void onEnable() {
        instance = this;
        players = new ArrayList<>();

        plotWorld = CoreSystem.getInstance().getWorldManager().getWorld("plots");
        CoreSystem.getInstance().getTranslationManager().loadCategories(this);

        Broadcast.schedule();

        registerCommands(
                new HeadCMD(),
                new AdvertisingCMD(),
                new SignaturCMD(),
                new FarmWorldCMD(),
                new NetherCMD(),
                new BorderCMD(),
                new CraftCMD()
        );
        registerEvents(
                new NpcInteract(),
                new PlayerJoinListener(),
                new WeatherChangeListener(),
                new PlayerAchievementAwardedListener(),
                new PlayerDeathListener(),
                new PlayerRespawnListener(),
                new PlayerQuitListener(),
                new MoneyChangeListener()
        );
        CoreSystem.getInstance().enableSpawnCommand(this, plotWorld, 3);
        CoreSystem.getInstance().enableTpaSystem(this, 3);
        CoreSystem.getInstance().enableEnderchestSystem(this);
        CoreSystem.getInstance().enableHomeSystem(this, this, 3);

        for (CorePlayer p : CoreSystem.getInstance().getOnlineCorePlayers()) {
            p.getScoreboard().setNewObjective(new SidebarObjective());
            new CitybuildPlayer(p);
        }

        sendConsoleMessage("§aVersion §f" + this.getDescription().getVersion() + "§a enabled!");
    }

    @Override
    public void onDisable() {
        for (CitybuildPlayer sp : getCitybuildPlayers()) {
            sp.saveData();
        }

        sendConsoleMessage("§cPlugin disabled!");
    }

    public CitybuildPlayer getCitybuildPlayer(UUID uuid) {
        for (CitybuildPlayer sp : players) {
            if (sp.getCorePlayer().getUuid().equals(uuid)) {
                return sp;
            }
        }
        return null;
    }

    public CitybuildPlayer getCitybuildPlayer(String name) {
        for (CitybuildPlayer sp : players) {
            if (sp.getCorePlayer().getName().equals(name)) {
                return sp;
            }
        }
        return null;
    }

    public Collection<CitybuildPlayer> getCitybuildPlayers() {
        return players;
    }

    public void registerCitybuildPlayer(CitybuildPlayer sp) {
        players.add(sp);
    }

    public void unregisterCitybuildPlayer(CitybuildPlayer sp) {
        players.remove(sp);
    }

    @Override
    public HomeManager getHomeManager(Player player) {
        return getCitybuildPlayer(player.getUniqueId());
    }

    @Override
    public EnderchestManager getEnderchestManager(Player player) {
        return getCitybuildPlayer(player.getUniqueId());
    }
}
