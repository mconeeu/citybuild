/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.listener;

import eu.mcone.citybuild.Inventorys.purchaser.PurchaserInventory;
import eu.mcone.citybuild.Inventorys.trader.TraderSurvivalInventory;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.event.NpcInteractEvent;
import eu.mcone.coresystem.api.bukkit.npc.NPC;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import net.minecraft.server.v1_13_R2.ItemStack;
import net.minecraft.server.v1_13_R2.PacketPlayInUseEntity;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.MainHand;

public class NpcInteract implements Listener {

    @EventHandler
    public void on(NpcInteractEvent e) {
        Player p = e.getPlayer();
        NPC npc = e.getNpc();
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        if (e.getNpc().getData().getType().equals(EntityType.PLAYER) && e.getAction().equals(PacketPlayInUseEntity.EnumEntityUseAction.INTERACT)) {
            switch (npc.getData().getName()) {
                case "tradercb":
                    new TraderSurvivalInventory(p);
                    break;

                case "purchaser":

                    if (p.getInventory().getItemInMainHand().getType().equals(PurchaserInventory.Items.STONE.getItemToSell().getType())
                            && p.getInventory().getItemInMainHand().getAmount() == PurchaserInventory.Items.STONE.getItemToSell().getAmount()) {

                        cp.addCoins(PurchaserInventory.Items.STONE.getCoins());
                        p.getInventory().removeItem(p.getInventory().getItemInMainHand());
                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                        p.sendMessage("§8[§7§l!§8] §fServer §8» §7Du hast das " + PurchaserInventory.Items.STONE.getDisplayName() + "§7 für §a " + PurchaserInventory.Items.STONE.getCoins() + "§7gekauft!");
                    } else {
                        p.sendMessage("§8[§7§l!§8] §fServer §8» §cDu musst mindestens 1 Stack der Angeboten Artikel in der Hand halten, um sie zu verkaufen!");
                        new PurchaserInventory(p);
                    }

                    if (p.getInventory().getItemInMainHand().getType().equals(PurchaserInventory.Items.COBBLESTONE.getItemToSell().getType())
                            && p.getInventory().getItemInMainHand().getAmount() == PurchaserInventory.Items.COBBLESTONE.getItemToSell().getAmount()) {

                        cp.addCoins(PurchaserInventory.Items.COBBLESTONE.getCoins());
                        p.getInventory().removeItem(p.getInventory().getItemInMainHand());
                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                        p.sendMessage("§8[§7§l!§8] §fServer §8» §7Du hast das " + PurchaserInventory.Items.COBBLESTONE.getDisplayName() + "§7 für §a " + PurchaserInventory.Items.STONE.getCoins() + "§7gekauft!");
                    } else {
                        new PurchaserInventory(p);
                    }

                    if (p.getInventory().getItemInMainHand().getType().equals(PurchaserInventory.Items.OAK_WOOD.getItemToSell().getType())
                            && p.getInventory().getItemInMainHand().getAmount() == PurchaserInventory.Items.OAK_WOOD.getItemToSell().getAmount()) {

                        cp.addCoins(PurchaserInventory.Items.OAK_WOOD.getCoins());
                        p.getInventory().removeItem(p.getInventory().getItemInMainHand());
                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                        p.sendMessage("§8[§7§l!§8] §fServer §8» §7Du hast das " + PurchaserInventory.Items.OAK_WOOD.getDisplayName() + "§7 für §a " + PurchaserInventory.Items.STONE.getCoins() + "§7gekauft!");
                    } else {
                        new PurchaserInventory(p);
                    }

                    if (p.getInventory().getItemInMainHand().getType().equals(PurchaserInventory.Items.JUNGLE_WOOD.getItemToSell().getType())
                            && p.getInventory().getItemInMainHand().getAmount() == PurchaserInventory.Items.JUNGLE_WOOD.getItemToSell().getAmount()) {

                        cp.addCoins(PurchaserInventory.Items.JUNGLE_WOOD.getCoins());
                        p.getInventory().removeItem(p.getInventory().getItemInMainHand());
                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                        p.sendMessage("§8[§7§l!§8] §fServer §8» §7Du hast das " + PurchaserInventory.Items.JUNGLE_WOOD.getDisplayName() + "§7 für §a " + PurchaserInventory.Items.STONE.getCoins() + "§7gekauft!");
                    } else {
                        p.sendMessage("§8[§7§l!§8] §fServer §8» §cDu musst mindestens 1 Stack der Angeboten Artikel in der Hand halten, um sie zu verkaufen!");
                        new PurchaserInventory(p);
                    }

                    if (p.getInventory().getItemInMainHand().getType().equals(PurchaserInventory.Items.BIRCH_WOOD.getItemToSell().getType())
                            && p.getInventory().getItemInMainHand().getAmount() == PurchaserInventory.Items.BIRCH_WOOD.getItemToSell().getAmount()) {

                        cp.addCoins(PurchaserInventory.Items.BIRCH_WOOD.getCoins());
                        p.getInventory().removeItem(p.getInventory().getItemInMainHand());
                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                        p.sendMessage("§8[§7§l!§8] §fServer §8» §7Du hast das " + PurchaserInventory.Items.BIRCH_WOOD.getDisplayName() + "§7 für §a " + PurchaserInventory.Items.STONE.getCoins() + "§7gekauft!");
                    } else {
                        p.sendMessage("§8[§7§l!§8] §fServer §8» §cDu musst mindestens 1 Stack der Angeboten Artikel in der Hand halten, um sie zu verkaufen!");
                        new PurchaserInventory(p);
                    }

                    if (p.getInventory().getItemInMainHand().getType().equals(PurchaserInventory.Items.ACACIA_WOOD.getItemToSell().getType())
                            && p.getInventory().getItemInMainHand().getAmount() == PurchaserInventory.Items.ACACIA_WOOD.getItemToSell().getAmount()) {

                        cp.addCoins(PurchaserInventory.Items.ACACIA_WOOD.getCoins());
                        p.getInventory().removeItem(p.getInventory().getItemInMainHand());
                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                        p.sendMessage("§8[§7§l!§8] §fServer §8» §7Du hast das " + PurchaserInventory.Items.ACACIA_WOOD.getDisplayName() + "§7 für §a " + PurchaserInventory.Items.STONE.getCoins() + "§7gekauft!");
                    } else {
                        p.sendMessage("§8[§7§l!§8] §fServer §8» §cDu musst mindestens 1 Stack der Angeboten Artikel in der Hand halten, um sie zu verkaufen!");
                        new PurchaserInventory(p);
                    }

                    if (p.getInventory().getItemInMainHand().getType().equals(PurchaserInventory.Items.SPRUCE_WOOD.getItemToSell().getType())
                            && p.getInventory().getItemInMainHand().getAmount() == PurchaserInventory.Items.SPRUCE_WOOD.getItemToSell().getAmount()) {

                        cp.addCoins(PurchaserInventory.Items.SPRUCE_WOOD.getCoins());
                        p.getInventory().removeItem(p.getInventory().getItemInMainHand());
                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                        p.sendMessage("§8[§7§l!§8] §fServer §8» §7Du hast das " + PurchaserInventory.Items.SPRUCE_WOOD.getDisplayName() + "§7 für §a " + PurchaserInventory.Items.STONE.getCoins() + "§7gekauft!");
                    } else {
                        p.sendMessage("§8[§7§l!§8] §fServer §8» §cDu musst mindestens 1 Stack der Angeboten Artikel in der Hand halten, um sie zu verkaufen!");
                        new PurchaserInventory(p);
                    }






                    break;
            }
        }
    }
}