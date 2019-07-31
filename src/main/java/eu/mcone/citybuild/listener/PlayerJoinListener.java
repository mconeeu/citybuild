/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.listener;

import eu.mcone.citybuild.Citybuild;
import eu.mcone.citybuild.item.Perk;
import eu.mcone.citybuild.player.CitybuildPlayer;
import eu.mcone.citybuild.util.SidebarObjective;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.util.CoreActionBar;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.DisplaySlot;

public class PlayerJoinListener implements Listener {

    private final static CoreActionBar LOADING_MSG = CoreSystem.getInstance().createActionBar().message(new BaseComponent[]{new TextComponent("§7§oDeine Daten werden geladen...").duplicate()});
    private final static CoreActionBar LOADING_SUCCESS_MSG = CoreSystem.getInstance().createActionBar().message(new BaseComponent[]{new TextComponent("§2§oDeine Daten wurden geladen!").duplicate()});

    @EventHandler
    public void on(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);
        CitybuildPlayer cbp = Citybuild.getInstance().getCitybuildPlayer(p.getUniqueId());

        p.setAllowFlight(true);
        if (p.hasPermission("citybuild.join.vanish")) {
            cp.setVanished(true);
        }

        if (cbp.hasPerk(Perk.FIRE_RESISTANCE)) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1));
        }

        if (cbp.hasPerk(Perk.NIGHT_VISION)) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1));
        }

        if (cbp.hasPerk(Perk.SPEED)) {
            p.setWalkSpeed(0.22F);
        }

        if (cbp.hasPerk(Perk.WATER_BREATHING)) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 0));
        }


        for (CorePlayer t : CoreSystem.getInstance().getOnlineCorePlayers()) {
            if (t != cp) {
                t.getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
            }
        }


        LOADING_MSG.send(p);

        Bukkit.getScheduler().runTask(Citybuild.getInstance(), () -> {
            new CitybuildPlayer(cp);

            cp.getScoreboard().setNewObjective(new SidebarObjective());
            p.getPlayer().playEffect(p.getPlayer().getLocation(), Effect.ENDER_SIGNAL, 10);
            LOADING_SUCCESS_MSG.send(p);
        });
    }
}
