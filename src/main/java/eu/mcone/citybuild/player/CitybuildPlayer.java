/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.player;

import eu.mcone.citybuild.Citybuild;
import eu.mcone.citybuild.item.Perk;
import eu.mcone.citybuild.scheduler.WorldReset;
import eu.mcone.citybuild.util.CitybuildChatColor;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.plugin.GamePlayerInventory;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.ChatColor;

import java.util.List;
import java.util.Set;

@Getter @Setter
public class CitybuildPlayer extends GamePlayerInventory<CitybuildPlayerProfile> {

    private ChatColor defaultChatColor;
    private Set<Perk> perks;
    private List<CitybuildChatColor> ownChatColors;

    public CitybuildPlayer(CorePlayer corePlayer) {
        super(corePlayer);
        Citybuild.getInstance().registerCitybuildPlayer(this);
    }

    @Override
    public CitybuildPlayerProfile reload() {
        CitybuildPlayerProfile profile = super.reload();

        defaultChatColor = profile.getDefaultChatColor();
        perks = profile.getPerkSet();
        ownChatColors = profile.getOwnChatColors();

        if (profile.getLastLogin() < WorldReset.getLastReset()) {
            WorldReset.resetHomes(this);
            saveData();
        }

        return profile;
    }

    @Override
    protected CitybuildPlayerProfile loadData() {
        return Citybuild.getInstance().loadGameProfile(corePlayer.bukkit(), CitybuildPlayerProfile.class);
    }

    public void addPerk(Perk perk) {
        perks.add(perk);
        saveData();
    }

    public void addChatColor(CitybuildChatColor color) {
        ownChatColors.add(color);
        saveData();
    }

    public boolean hasChatColor(CitybuildChatColor color) {
        return ownChatColors.contains(color);
    }

    public boolean hasPerk(Perk perk) {
        return perks.contains(perk);
    }

    public void saveData() {
        Citybuild.getInstance().saveGameProfile(new CitybuildPlayerProfile(corePlayer.bukkit(), enderchest, homes, perks, defaultChatColor));
    }

}
