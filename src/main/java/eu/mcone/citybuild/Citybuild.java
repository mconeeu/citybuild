package eu.mcone.citybuild;

import eu.mcone.citybuild.command.*;
import eu.mcone.citybuild.listener.*;
import eu.mcone.citybuild.util.SidebarObjective;
import eu.mcone.coresystem.api.bukkit.CorePlugin;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import lombok.Getter;
import org.bukkit.ChatColor;

public class Citybuild extends CorePlugin {

    @Getter
    private static Citybuild instance;

    @Getter
    private CoreWorld plotWorld;

    public Citybuild() {
        super("citybuild", ChatColor.AQUA, "citybuild.prefix");
    }

    @Override
    public void onEnable() {
        instance = this;
        this.plotWorld = CoreSystem.getInstance().getWorldManager().getWorld("plots");
        CoreSystem.getInstance().getTranslationManager().loadCategories(this);

        Broadcast.schedule();

        registerCommands(
                new PayCMD(),
                new HeadCMD(),
                new AdvertisingCMD(),
                new SignaturCMD(),
                new FarmWorldCMD(),
                new NetherCMD(),
                new BorderCMD(),
                new CraftCMD()
        );
        CoreSystem.getInstance().enableSpawnCommand(plotWorld);

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

        for (CorePlayer p : CoreSystem.getInstance().getOnlineCorePlayers()) {
            p.getScoreboard().setNewObjective(new SidebarObjective());
        }

        sendConsoleMessage("§aVersion §f" + this.getDescription().getVersion() + "§a enabled!");
    }

    @Override
    public void onDisable() {

    }

}
