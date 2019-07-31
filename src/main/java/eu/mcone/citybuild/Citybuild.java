/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild;

import eu.mcone.citybuild.command.*;
import eu.mcone.citybuild.listener.*;
import eu.mcone.citybuild.player.CitybuildPlayer;
import eu.mcone.citybuild.scheduler.Broadcast;
import eu.mcone.citybuild.scheduler.ClearLag;
import eu.mcone.citybuild.scheduler.WorldReset;
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
import eu.mcone.coresystem.api.bukkit.world.WorldCreateProperties;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
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
    @Getter
    private CoreWorld farmWorld;
    @Getter
    private CoreWorld nether;
    private List<CitybuildPlayer> players;

    @Getter
    private CoreJsonConfig citybuildConfig;

    public Citybuild() {
        super("citybuild", ChatColor.AQUA, "citybuild.prefix");
    }

    @Override
    public void onEnable() {
        instance = this;
        players = new ArrayList<>();

        citybuildConfig = new CoreJsonConfig(this, "config.json");
        if (!citybuildConfig.getJson().getAsJsonObject().has("lastReset")) {
            citybuildConfig.getJson().getAsJsonObject().addProperty("lastReset", System.currentTimeMillis() / 1000);
            citybuildConfig.save();
        }

        plotWorld = CoreSystem.getInstance().getWorldManager().getWorld("plots");
        setWorlds();

        CoreSystem.getInstance().getTranslationManager().loadCategories(this);

        sendConsoleMessage("§aRegistering Events & Commands & Scheduler...");
        registerCommands(
                new HeadCMD(),
                new AdvertisingCMD(),
                new SignCMD(),
                new FarmWorldCMD(),
                new NetherCMD(),
                new BorderCMD(),
                new CraftCMD(),
                new SpecCMD(),
                new BoosterCMD(),
                new ColorCMD(),
                new XpCMD(),
                new GlowCMD(),
                new BroadcastCMD()
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
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, new WorldReset(), 0, 60 * 60 * 20);
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, new Broadcast(), 0, 3 * 60 * 20);
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, new ClearLag(), 0, 9 * 60 * 20);

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
        for (CitybuildPlayer cbp : getCitybuildPlayers()) {
            cbp.saveData();
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

    public void unsetWorlds() {
        this.farmWorld = null;
        this.nether = null;
    }

    private void setWorlds() {
        if (CoreSystem.getInstance().getWorldManager().getWorld("Farmworld") == null) {
            CoreSystem.getInstance().getWorldManager().createWorld("Farmworld", WorldCreateProperties.builder().spawnAnimals(true).spawnMonsters(true).build());
        }
        if (CoreSystem.getInstance().getWorldManager().getWorld("Nether") == null) {
            CoreSystem.getInstance().getWorldManager().createWorld("Nether", WorldCreateProperties.builder().environment(World.Environment.NETHER).spawnAnimals(true).spawnMonsters(true).build());
        }

        this.farmWorld = CoreSystem.getInstance().getWorldManager().getWorld("Farmworld");
        this.nether = CoreSystem.getInstance().getWorldManager().getWorld("Nether");
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
