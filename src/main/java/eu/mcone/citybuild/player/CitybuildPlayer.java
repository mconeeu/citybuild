package eu.mcone.citybuild.player;

import eu.mcone.citybuild.Citybuild;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.plugin.GamePlayerInventory;

public class CitybuildPlayer extends GamePlayerInventory<CitybuildPlayerProfile> {

    public CitybuildPlayer(CorePlayer corePlayer) {
        super(corePlayer);
        Citybuild.getInstance().registerCitybuildPlayer(this);
    }

    @Override
    protected CitybuildPlayerProfile loadData() {
        return Citybuild.getInstance().loadGameProfile(corePlayer.bukkit(), CitybuildPlayerProfile.class);
    }

    public void saveData() {
        Citybuild.getInstance().saveGameProfile(new CitybuildPlayerProfile(corePlayer.bukkit(), enderchest, homes));
    }

}
