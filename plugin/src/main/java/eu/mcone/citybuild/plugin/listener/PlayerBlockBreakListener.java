/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.plugin.listener;

import eu.mcone.citybuild.api.CitybuildPlugin;
import eu.mcone.citybuild.api.item.Perk;
import eu.mcone.citybuild.api.player.CitybuildPlayer;
import net.minecraft.server.v1_13_R2.BlockPosition;
import net.minecraft.server.v1_13_R2.PacketPlayOutBlockBreakAnimation;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerBlockBreakListener implements Listener {

    @EventHandler
    public void on(BlockBreakEvent e) {
        Player p = e.getPlayer();
        CitybuildPlayer cbp = CitybuildPlugin.getInstance().getCitybuildPlayer(p.getUniqueId());

        //Todo: Check if that works
//        Location blockLocation = e.getBlock().getLocation();
//        BlockPosition blockPosition = new BlockPosition(blockLocation.getBlockX(), blockLocation.getBlockY(), blockLocation.getBlockZ());
//        PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(100, blockPosition, 100);
//        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);

        if (e.getBlock().getType().equals(Material.SPAWNER)) {
            if (cbp.hasPerk(Perk.BREAK_BLOCK) && cbp.isPerkActivated(Perk.BREAK_BLOCK)) {
                if (p.getGameMode() == GameMode.SURVIVAL) {
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    e.getBlock().getDrops().add(new ItemStack(Material.SPAWNER));
                    p.getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.SPAWNER, 1));
                }
            }
        }

        if (e.getBlock().getType().equals(Material.BEDROCK)) {
            if (p.getGameMode() == GameMode.SURVIVAL) {
                if (p.hasPermission("citybuild.perks.break")) {
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    e.getBlock().getDrops().add(new ItemStack(Material.BEDROCK));
                    p.getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.BEDROCK, 1));
                }
            }
        }

        if (e.getBlock().getType().equals(Material.END_STONE)) {
            if (p.getGameMode() == GameMode.SURVIVAL) {
                if (p.hasPermission("citybuild.perks.break")) {
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    e.getBlock().getDrops().add(new ItemStack(Material.END_STONE));
                    p.getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.END_STONE, 1));
                }
            }
        }

        if (e.getBlock().getType().equals(Material.END_PORTAL_FRAME)) {
            if (p.getGameMode() == GameMode.SURVIVAL) {
                if (p.hasPermission("citybuild.perks.break")) {
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    p.getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.END_PORTAL_FRAME, 1));
                }
            }
        }

        if (e.getBlock().getType().equals(Material.BARRIER)) {
            if (p.hasPermission("citybuild.perks.break")) {
                if (p.getGameMode() == GameMode.SURVIVAL) {
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    e.getBlock().getDrops().add(new ItemStack(Material.BARRIER));
                    p.getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.BARRIER, 1));
                }
            }
        }
    }
}






