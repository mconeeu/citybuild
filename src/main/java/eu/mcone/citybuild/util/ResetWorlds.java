package eu.mcone.citybuild.util;

import eu.mcone.citybuild.Citybuild;
import eu.mcone.citybuild.player.CitybuildPlayerProfile;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;

public class ResetWorlds {

    private long restartTime;
    private BukkitTask bukkitTask;

    public ResetWorlds(final long resetTime) {
        this.restartTime = resetTime;
    }

    public void startAsyncTask() {
        World farmWorld = Bukkit.getWorld("farmwelt");
        World nether = Bukkit.getWorld("nether");

        this.bukkitTask = Bukkit.getScheduler().runTaskTimerAsynchronously(Citybuild.getInstance(), () -> {
            long difference = System.currentTimeMillis() / 1000 - restartTime;

            if (difference <= 0) {
                //Teleport all players to spawn
                for (CorePlayer cp : CoreSystem.getInstance().getOnlineCorePlayers()) {
                    if (cp.getWorld().bukkit().equals(farmWorld)
                            || cp.getWorld().bukkit().equals(nether)) {
                        cp.bukkit().teleport(Citybuild.getInstance().getPlotWorld().getLocation("spawn"));
                    }
                }

                for (CitybuildPlayerProfile citybuildPlayerProfile : CoreSystem.getInstance().getMongoDB().getCollection("citybuild_profile", CitybuildPlayerProfile.class).find()) {
                    CorePlayer corePlayer = CoreSystem.getInstance().getCorePlayer(citybuildPlayerProfile.getUuid());
                    for (Map.Entry<String, Location> homeEntry : Citybuild.getInstance().getHomeManager(corePlayer.bukkit()).getHomes().entrySet()) {
                        if (homeEntry.getValue().getWorld().getName().equalsIgnoreCase(farmWorld.getName())
                                && homeEntry.getValue().getWorld().getName().equalsIgnoreCase(nether.getName())) {
                            //TODO: use removeHomeLocaly methode
                            Citybuild.getInstance().getHomeManager(corePlayer.bukkit()).removeHome(homeEntry.getKey());
                        }
                    }

                    Citybuild.getInstance().getCitybuildPlayer(citybuildPlayerProfile.getUuid()).saveData();
                }


                //Delete and create farm world
                CoreSystem.getInstance().getWorldManager().getWorld(farmWorld).delete();
                CoreSystem.getInstance().getWorldManager().createWorld("farmwelt", getSettings(farmWorld));

                //Delete and create nether
                CoreSystem.getInstance().getWorldManager().getWorld(nether).delete();
                CoreSystem.getInstance().getWorldManager().createWorld("nether", getSettings(nether));

                //Update Config
                this.restartTime = (System.currentTimeMillis() / 1000) + 259200;
                Citybuild.getInstance().getCityBuildConfig().setLastStart(restartTime);
                Citybuild.getInstance().getJsonCityBuildConfig().updateConfig(Citybuild.getInstance().getCityBuildConfig());
            } else {
                //1 min
                if (difference <= 60) {
                    Bukkit.getOnlinePlayers().forEach((player) -> Citybuild.getInstance().getMessager().send(player, "§cIn 10 Sekunden werden alle gedroppten Items gelöscht!"));
                    //30 min
                } else if (difference <= 1800) {

                    //60 min
                } else if (difference <= 3600) {

                }
            }
        }, 0, 28800);
    }

    public void stopAsyncTask() {
        Citybuild.getInstance().getServer().getScheduler().cancelTask(bukkitTask.getTaskId());
    }

    private Map<String, String> getSettings(final World world) {
        return new HashMap<String, String>() {{
            put("environment", world.getEnvironment().toString());
            put("type", world.getWorldType().toString());
            put("pvp", Boolean.toString(world.getPVP()));
        }};
    }
}
