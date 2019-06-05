package eu.mcone.citybuild.listener;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class PlayerBlockBreakListener implements Listener {

    @EventHandler
    public void on(BlockBreakEvent e) {
        Player p = e.getPlayer();

        if (e.getBlock().getType().equals(Material.MOB_SPAWNER)) {
            if (p.hasPermission("citybuild.perks.break")) {
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                e.getBlock().getDrops().add(new ItemStack(Material.MOB_SPAWNER));
                p.getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.MOB_SPAWNER, 1));
            }
        }

        if (e.getBlock().getType().equals(Material.BEDROCK)) {
            if (p.hasPermission("citybuild.perks.break")) {
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                e.getBlock().getDrops().add(new ItemStack(Material.BEDROCK));
                p.getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.BEDROCK, 1));
            }
        }

        if (e.getBlock().getType().equals(Material.ENDER_STONE)) {
            if (p.hasPermission("citybuild.perks.break")) {
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                e.getBlock().getDrops().add(new ItemStack(Material.ENDER_STONE));
                p.getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.ENDER_STONE, 1));
            }
        }

        if (e.getBlock().getType().equals(Material.ENDER_PORTAL_FRAME)) {
            if (p.hasPermission("citybuild.perks.break")) {
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                p.getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.ENDER_PORTAL_FRAME, 1));

            }
        }

        if (e.getBlock().getType().equals(Material.BARRIER)) {
            if (p.hasPermission("citybuild.perks.break")) {
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                e.getBlock().getDrops().add(new ItemStack(Material.BARRIER));
                p.getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.BARRIER, 1));
            }
        }
    }
}






