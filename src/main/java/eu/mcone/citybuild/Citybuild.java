package eu.mcone.citybuild;

import eu.mcone.citybuild.command.*;
import eu.mcone.citybuild.listener.*;
import eu.mcone.citybuild.player.CitybuildPlayer;
import eu.mcone.citybuild.util.Broadcast;
import eu.mcone.citybuild.util.CityBuildConfig;
import eu.mcone.citybuild.util.SidebarObjective;
import eu.mcone.coresystem.api.bukkit.CorePlugin;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.config.CoreJsonConfig;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.profile.interfaces.EnderchestManager;
import eu.mcone.coresystem.api.bukkit.player.profile.interfaces.EnderchestManagerGetter;
import eu.mcone.coresystem.api.bukkit.player.profile.interfaces.HomeManager;
import eu.mcone.coresystem.api.bukkit.player.profile.interfaces.HomeManagerGetter;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
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

    @Getter
    private CoreJsonConfig<CityBuildConfig> jsonCityBuildConfig;
    @Getter
    private CityBuildConfig cityBuildConfig;

    public Citybuild() {
        super("citybuild", ChatColor.AQUA, "citybuild.prefix");
    }

    @Override
    public void onEnable() {
        instance = this;
        players = new ArrayList<>();

        Bukkit.getScheduler().runTaskTimerAsynchronously(this, () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                getMessager().send(p, "§cIn einer Minute werden alle gedroppten Items gelöscht!");
            }

            Bukkit.getScheduler().runTaskLaterAsynchronously(this, () -> {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    getMessager().send(p, "§cIn 10 Sekunden werden alle gedroppten Items gelöscht!");
                }

                Bukkit.getScheduler().runTaskLater(this, () -> {
                    for (Entity e : plotWorld.bukkit().getEntities()) {
                        if (e.getType().equals(EntityType.DROPPED_ITEM) || e.getType().equals(EntityType.MINECART) || e.getType().equals(EntityType.BOAT) || e.getType().equals(EntityType.EXPERIENCE_ORB)) {
                            e.remove();
                        }
                    }

                    for (Player p : Bukkit.getOnlinePlayers()) {
                        getMessager().send(p, "§cAlle gedroppten Items wurden gelöscht!");
                    }
                }, 200);
            }, 1000);
        }, 0, 4800);

        jsonCityBuildConfig = new CoreJsonConfig<>(this, CityBuildConfig.class, "cityBuild.json");
        jsonCityBuildConfig.updateConfig(new CityBuildConfig((System.currentTimeMillis() / 1000) + 259200));
        cityBuildConfig = jsonCityBuildConfig.parseConfig();



        plotWorld = CoreSystem.getInstance().getWorldManager().getWorld("plots");
        CoreSystem.getInstance().getTranslationManager().loadCategories(this);
        CoreSystem.getInstance().setPlayerChatEnabled(false);

        Broadcast.schedule();

        registerCommands(
                new HeadCMD(),
                new AdvertisingCMD(),
                new SignaturCMD(),
                new FarmWorldCMD(),
                new NetherCMD(),
                new BorderCMD(),
                new CraftCMD(),
                new BarriereCMD(),
                new SpecCMD(),
                new BoosterCMD()
        );
        registerEvents(
                new NpcInteract(),
                new PlayerJoinListener(),
                new WeatherChangeListener(),
                new PlayerAchievementAwardedListener(),
                new PlayerDeathListener(),
                new PlayerRespawnListener(),
                new PlayerQuitListener(),
                new MoneyChangeListener(),
                new PlayerDamageListener(),
                new PlayerBlockBreakListener(),
                new FoodChangeListener(),
                new PlayerChatListener()
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
