/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.api.player;

import eu.mcone.citybuild.api.CitybuildPlugin;
import eu.mcone.citybuild.api.item.Perk;
import eu.mcone.citybuild.api.scheduler.WorldReset;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.plugin.GamePlayerInventory;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.ChatColor;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;

@Getter
@Setter
public class CitybuildPlayer extends GamePlayerInventory<CitybuildPlayerProfile> {

    private ChatColor defaultChatColor;
    private Map<Perk, Boolean> perks;

    public CitybuildPlayer(CorePlayer corePlayer) {
        super(corePlayer);
        CitybuildPlugin.getInstance().registerCitybuildPlayer(this);
    }

    @Override
    public CitybuildPlayerProfile reload() {
        CitybuildPlayerProfile profile = super.reload();

        defaultChatColor = profile.getDefaultChatColor();
        perks = profile.getPerksMap();

        if (profile.getLastLogin() < WorldReset.getLastReset()) {
            WorldReset.resetHomes(this);
            saveData();
        }

        return profile;
    }

    @Override
    protected CitybuildPlayerProfile loadData() {
        return CitybuildPlugin.getInstance().loadGameProfile(corePlayer.bukkit(), CitybuildPlayerProfile.class);
    }

    public void addPerk(Perk perk) {
        perks.put(perk, true);
    }

    public void addPerk(Perk perk, boolean var) {
        perks.put(perk, var);
    }

    public boolean isPerkActivated(Perk perk) {
        for (Map.Entry<Perk, Boolean> entry : perks.entrySet()) {
            if (entry.getKey().equals(perk)) {
                return entry.getValue();
            }
        }

        return false;
    }

    public void disablePerk(Perk perk, boolean var) {
        if (hasPerk(perk)) {
            if (perks.containsKey(perk)) {
                perks.put(perk, var);

                if (perk.getPerkCategory().equals(Perk.PerkCategory.EFFECT)) {
                    setEffect(perk, var);
                } else if (perk.getPerkCategory().equals(Perk.PerkCategory.MOVEMENT)) {
                    setMovement(perk, var);
                }
            }
        }
    }

    public boolean hasPerk(Perk perk) {
        return perks.containsKey(perk) || bukkit().hasPermission("citybuild.perks");
    }

    public void saveData() {
        CitybuildPlugin.getInstance().saveGameProfile(new CitybuildPlayerProfile(corePlayer.bukkit(), enderchest, homes, perks, defaultChatColor));
    }

    public void setEffect(Perk perk, boolean remove) {
        if (perk.equals(Perk.FIRE_RESISTANCE)) {
            if (remove) {
                bukkit().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
            } else {
                bukkit().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1));
            }
        } else if (perk.equals(Perk.NIGHT_VISION)) {
            if (remove) {
                bukkit().removePotionEffect(PotionEffectType.NIGHT_VISION);
            } else {
                bukkit().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1));
            }
        } else if (perk.equals(Perk.WATER_BREATHING)) {
            if (remove) {
                bukkit().removePotionEffect(PotionEffectType.WATER_BREATHING);
            } else {
                bukkit().addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 0));
            }
        }
    }

    public void setMovement(Perk perk, boolean remove) {
        if (perk.equals(Perk.SPEED)) {
            if (remove) {
                bukkit().setWalkSpeed(0.1F);
            } else {
                bukkit().setWalkSpeed(0.22F);
            }
        }
    }
}
