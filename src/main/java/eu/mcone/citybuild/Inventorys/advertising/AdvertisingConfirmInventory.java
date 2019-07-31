/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.Inventorys.advertising;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

class AdvertisingConfirmInventory extends CoreInventory {

    AdvertisingConfirmInventory(Player p, Player t, AdverisingModeLevelInventory.ModeLevelMsg modeLevelMsg) {
        super("§f§lKaufe nun deine Werbung", p, InventorySlot.ROW_3);
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        setItem(InventorySlot.ROW_2_SLOT_2, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE,1).displayName("§a§lKaufe die Werbung").create(), e -> {
            switch (modeLevelMsg.mode) {
                case SHOP: {
                    switch (modeLevelMsg.level) {
                        case DEFAULT: {
                            sendToAll("§c»\n" +
                                    "§f§lBesuche doch mal den Shop von " + t.getName() + "\n" +
                                    "§c»");
                            break;
                        }
                        case EPIC: {
                            sendToAll(
                                    new ComponentBuilder("§c»")
                                            .append("\n§c§lBesuche doch mal den Shop von " + t.getName())
                                            .append("\n")
                                            .append("[Zum Plot teleportieren]")
                                            .color(ChatColor.GREEN)
                                            .bold(true)
                                            .event(new HoverEvent(
                                                    HoverEvent.Action.SHOW_TEXT,
                                                    new ComponentBuilder("§7§oKlicke hier, um dich zum Plot zu teleportieren").create()
                                            ))
                                            .event(new ClickEvent(
                                                    ClickEvent.Action.RUN_COMMAND,
                                                    "/plot home " + t.getName()
                                            ))
                                            .append("\n§c»")
                                            .create()
                            );
                            break;
                        }
                        case EXCLUSIVE: {
                            sendToAll(
                                    new ComponentBuilder("§c»")
                                            .append("\n\n")
                                            .append(modeLevelMsg.msg)
                                            .append(" [Zum Plot teleportieren]")
                                            .color(ChatColor.GREEN)
                                            .bold(true)
                                            .event(new HoverEvent(
                                                    HoverEvent.Action.SHOW_TEXT,
                                                    new ComponentBuilder("§7§oKlicke hier, um dich zum Plot zu teleportieren").create()
                                            ))
                                            .event(new ClickEvent(
                                                    ClickEvent.Action.RUN_COMMAND,
                                                    "/plot home " + t.getName()
                                            ))
                                            .append("\n\n§c»")
                                            .create()
                            );
                            break;
                        }
                    }

                    break;
                }
                case EVENT: {
                    switch (modeLevelMsg.level) {
                        case DEFAULT: {
                            sendToAll("§c»\n" +
                                    "§f§lBesuche doch mal das Event von " + t.getName() + "\n" +
                                    "§c»");
                            break;
                        }
                        case EPIC: {
                            sendToAll(
                                    new ComponentBuilder("§c»")
                                            .append("\n§c§lBesuche doch mal das Event von " + t.getName())
                                            .append("\n")
                                            .append("[Zum Plot teleportieren]")
                                            .color(ChatColor.GREEN)
                                            .bold(true)
                                            .event(new HoverEvent(
                                                    HoverEvent.Action.SHOW_TEXT,
                                                    new ComponentBuilder("§7§oKlicke hier, um dich zum Event zu teleportieren").create()
                                            ))
                                            .event(new ClickEvent(
                                                    ClickEvent.Action.RUN_COMMAND,
                                                    "/plot home " + t.getName()
                                            ))
                                            .append("\n§c»")
                                            .create());
                            break;
                        }
                        case EXCLUSIVE: {
                            sendToAll(
                                    new ComponentBuilder(modeLevelMsg.msg)
                                            .append(" [Zum Event teleportieren]")
                                            .color(ChatColor.GREEN)
                                            .bold(true)
                                            .event(new HoverEvent(
                                                    HoverEvent.Action.SHOW_TEXT,
                                                    new ComponentBuilder("§7§oKlicke hier, um dich zum Event zu teleportieren").create()
                                            ))
                                            .event(new ClickEvent(
                                                    ClickEvent.Action.RUN_COMMAND,
                                                    "/plot home " + t.getName()
                                            ))
                                            .create()
                            );
                            break;
                        }
                    }

                    break;
                }
            }

            cp.removeCoins(modeLevelMsg.level.coins);
            p.closeInventory();
        });


        setItem(InventorySlot.ROW_2_SLOT_8, new ItemBuilder(Material.RED_STAINED_GLASS_PANE,1).displayName("§c§lBreche den Vorgang ab!").create(), e -> {
            p.closeInventory();
        });

        openInventory();
    }

    private void sendToAll(String message) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(message);
        }
    }

    private void sendToAll(BaseComponent... message) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.spigot().sendMessage(message);
        }
    }

}
