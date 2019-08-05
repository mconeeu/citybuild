/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.api.player;

import eu.mcone.citybuild.api.item.Perk;
import eu.mcone.citybuild.api.util.CitybuildChatColor;
import eu.mcone.coresystem.api.bukkit.player.profile.PlayerInventoryProfile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.*;

@NoArgsConstructor
@Getter
@Setter
public class CitybuildPlayerProfile extends PlayerInventoryProfile {

    private ChatColor defaultChatColor = ChatColor.GRAY;
    private Map<Integer, Boolean> perks = new HashMap<>();
    private List<CitybuildChatColor> ownChatColors = new ArrayList<>();

    private transient Map<Perk, Boolean> perksMap = new HashMap<>();

    public CitybuildPlayerProfile(Player p, Inventory enderchest, Map<String, Location> homes, Map<Perk, Boolean> perks, ChatColor defaultChatColor) {
        super(p, enderchest, homes);

        this.defaultChatColor = defaultChatColor;

        for (Map.Entry<Perk, Boolean> entry : perks.entrySet()) {
            this.perks.put(entry.getKey().getId(), entry.getValue());
        }
    }

    @Override
    public void doSetData(Player p) {
        super.doSetData(p);

        for (Map.Entry<Integer, Boolean> entry : perks.entrySet()) {
            perksMap.put(Perk.getPerkById(entry.getKey()), entry.getValue());
        }
    }
}
