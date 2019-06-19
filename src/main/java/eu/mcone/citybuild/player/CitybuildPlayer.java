package eu.mcone.citybuild.player;

import eu.mcone.citybuild.Citybuild;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.plugin.GamePlayerInventory;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.ChatColor;

@Getter @Setter
public class CitybuildPlayer extends GamePlayerInventory<CitybuildPlayerProfile> {

    private ChatColor defaultChatColor;

    public CitybuildPlayer(CorePlayer corePlayer) {
        super(corePlayer);
        Citybuild.getInstance().registerCitybuildPlayer(this);
    }

    @Override
    protected CitybuildPlayerProfile loadData() {
        CitybuildPlayerProfile profile = Citybuild.getInstance().loadGameProfile(corePlayer.bukkit(), CitybuildPlayerProfile.class);
        defaultChatColor = profile.getDefaultChatColor();

        return profile;
    }

    public void saveData() {
        Citybuild.getInstance().saveGameProfile(new CitybuildPlayerProfile(corePlayer.bukkit(), enderchest, homes, defaultChatColor));
    }

}
