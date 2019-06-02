package eu.mcone.citybuild.player;

import eu.mcone.coresystem.api.bukkit.player.profile.PlayerInventoryProfile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Map;

@NoArgsConstructor
@Getter @Setter
public class CitybuildPlayerProfile extends PlayerInventoryProfile {

    public CitybuildPlayerProfile(Player p, Inventory enderchest, Map<String, Location> homes) {
        super(p, enderchest, homes);
    }

}
