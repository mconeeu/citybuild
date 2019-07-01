/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.player;

import eu.mcone.citybuild.item.Perk;
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
@Getter @Setter
public class CitybuildPlayerProfile extends PlayerInventoryProfile {

    private ChatColor defaultChatColor = ChatColor.GRAY;
    private List<Integer> perks = new ArrayList<>();

    private transient Set<Perk> perkSet = new HashSet<>();

    public CitybuildPlayerProfile(Player p, Inventory enderchest, Map<String, Location> homes, Set<Perk> perks, ChatColor defaultChatColor) {
        super(p, enderchest, homes);

        this.defaultChatColor = defaultChatColor;
        for (Perk perk : perks) {
            this.perks.add(perk.getId());
        }
    }

    @Override
    public void doSetData(Player p) {
        super.doSetData(p);

        for (int i : perks) {
            perkSet.add(Perk.getPerkById(i));
        }
    }
}
