package eu.mcone.citybuild.Inventorys;

import eu.mcone.citybuild.command.AdvertisingCMD;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;

public class TraderInventory extends CoreInventory {


    public TraderInventory(Player p) {
        super("§8» §e§lHändler §8| §fItems", p, InventorySlot.ROW_6);


        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        setItem(1, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());
        setItem(2, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());
        setItem(3, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());
        setItem(4, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());
        setItem(5, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());
        setItem(6, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());
        setItem(7, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());
        setItem(8, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());

        setItem(10, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());
        setItem(17, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());

        setItem(19, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());

        setItem(26, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());
        setItem(28, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());
        setItem(35, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());
        setItem(37, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());

        setItem(44, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());

        setItem(46, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());
        setItem(47, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());
        setItem(48, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());
        setItem(49, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());
        setItem(50, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());
        setItem(51, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());


        setItem(51, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());
        setItem(52, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());
        setItem(53, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 7).displayName("§8//§oMCONE§8//").create());

        setItem(InventorySlot.ROW_1_SLOT_1, new ItemBuilder(Material.IRON_SWORD, 1, 0).displayName("§c§lÜberlebungs-Items").lore("§7§oKaufe dir hier Überlebens Items.", "§7§oDie Items stehen dir danach in", "§7§odein Inventar zu verfügung.").enchantment(Enchantment.DAMAGE_ALL, 5).unbreakable(true).itemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE).create(),
                e -> {
                    p.playSound(p.getLocation(), Sound.NOTE_BASS, 1, 1);

                });

        setItem(InventorySlot.ROW_2_SLOT_1, new ItemBuilder(Material.MONSTER_EGG, 1, 0).displayName("§c§lTierspawn-Items").lore("§7§oKaufe dir hier Tier Spawneggs.", "§7§oDie Items stehen dir danach in", "§7§odeinem Inventar zur Verfügung.").create(),
                e -> {

                    p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
                    new TraderPetsInventory(p);

                });

        setItem(InventorySlot.ROW_3_SLOT_1, new ItemBuilder(Material.BREAD, 1, 0).displayName("§c§lEss-Items").lore("§7§oKaufe dir hier Essen.", "§7§oDie Items stehen dir danach in", "§7§odein Inventar zu verfügung.").create(),
                e -> {

                    p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
                    new TraderEatInventory(p);


                });

        setItem(InventorySlot.ROW_4_SLOT_1, new ItemBuilder(Material.ENCHANTMENT_TABLE, 1, 0).displayName("§c§lExklusive-Items").lore("§7§oKaufe dir hier Exklusive Items.", "§7§oDie Items stehen dir danach in", "§7§odein Inventar zu verfügung.").create(),
                e -> {

                    p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
                    new TraderExclusiveItems(p);


                });

        setItem(InventorySlot.ROW_5_SLOT_1, new ItemBuilder(Material.ARROW, 1, 0).displayName("§c§lMarkt-Liste").lore("§7§oGucke dir hier", "§7§oDie Preise der Aktuellen", "§7§oItems  an.").create(),
                e -> {

                    p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
                    new AdverisingModeInventory(p);



                });

        setItem(InventorySlot.ROW_6_SLOT_1, new ItemBuilder(Material.STICK, 1, 0).displayName("§c§lPerks").lore("§7§oKaufe dir hier", "§7§oPerks", "§7§ofür Exklusiven Spiel spaß!.").enchantment(Enchantment.DAMAGE_ALL, 5).unbreakable(true).itemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE).create(),
                e -> {

                    p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP,1,1);
                    new TraderPerksInventory(p);


                });






        setItem(InventorySlot.ROW_2_SLOT_3, new ItemBuilder(Material.STONE_SWORD, 1, 0).displayName("§f§lStein-Schwert").lore("", "§6§o50 Coins").enchantment(Enchantment.DAMAGE_ALL, 1).create(),
                e -> {
                    if (cp.getCoins() - 50 >= 0) {
                        cp.removeCoins(50);
                        p.getInventory().addItem(new ItemBuilder(Material.STONE_SWORD, 1, 0).displayName("§fStein-Schwert").enchantment(Enchantment.DAMAGE_ALL,1).create());


                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                    } else {
                        p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast nicht genügend Coins!");
                    }
                });

        setItem(InventorySlot.ROW_2_SLOT_4, new ItemBuilder(Material.STONE_PICKAXE, 1, 0).displayName("§f§lStein-Spitzhacke").lore("", "§6§o50 Coins").create(),
                e -> {

                    if (cp.getCoins() - 50 >= 0) {
                        cp.removeCoins(50);
                        p.getInventory().addItem(new ItemBuilder(Material.STONE_PICKAXE, 1, 0).displayName("§fStein-Spitzhacke").create());


                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                    } else {
                        p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast nicht genügend Coins!");
                    }
                });

        setItem(InventorySlot.ROW_2_SLOT_5, new ItemBuilder(Material.STONE_HOE, 1, 0).displayName("§f§lStein-Sense").lore("", "§6§o50 Coins").create(),
                e -> {


                    if (cp.getCoins() - 50 >= 0) {
                        cp.removeCoins(50);
                        p.getInventory().addItem(new ItemBuilder(Material.STONE_HOE, 1, 0).displayName("§fStein-Sense").create());


                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                    } else {
                        p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast nicht genügend Coins!");
                    }

                });

        setItem(InventorySlot.ROW_2_SLOT_6, new ItemBuilder(Material.STONE_AXE, 1, 0).displayName("§f§lStein-Axt").lore("", "§6§o100 Coins").create(),
                e -> {

                    if (cp.getCoins() - 100 >= 0) {
                        cp.removeCoins(100);
                        p.getInventory().addItem(new ItemBuilder(Material.STONE_AXE, 1, 0).displayName("§fStein-Axt").create());


                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                    } else {
                        p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast nicht genügend Coins!");
                    }

                });

        setItem(InventorySlot.ROW_2_SLOT_6, new ItemBuilder(Material.STONE_SPADE, 1, 0).displayName("§f§lStein-Schaufel").lore("", "§6§o100 Coins").create(),
                e -> {

                    if (cp.getCoins() - 100 >= 0) {
                        cp.removeCoins(100);
                        p.getInventory().addItem(new ItemBuilder(Material.STONE_SPADE, 1, 0).displayName("§fStein-Schaufel").create());


                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                    } else {
                        p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast nicht genügend Coins!");
                    }

                });


        openInventory();


    }
}
