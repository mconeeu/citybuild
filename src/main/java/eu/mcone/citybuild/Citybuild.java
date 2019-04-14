package eu.mcone.citybuild;

import eu.mcone.citybuild.command.*;
import eu.mcone.citybuild.listener.Broadcast;
import eu.mcone.citybuild.listener.NpcInteract;
import eu.mcone.citybuild.listener.PlayerJoinListener;
import eu.mcone.coresystem.api.bukkit.CorePlugin;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
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
        this.plotWorld = CoreSystem.getInstance().getWorldManager().getWorld("Citybuild");

        Broadcast.schedule();

        registerCommands(
                new PayCMD(),
                new HeadCMD(),
                new AdvertisingCMD(),
                new SignaturCMD(),
                new FarmWorldCMD(),
                new NetherCMD()
        );
        CoreSystem.getInstance().enableSpawnCommand(plotWorld);

        registerEvents(
                new NpcInteract(),
                new PlayerJoinListener()


        );
    }

    @Override
    public void onDisable() {

    }

}
