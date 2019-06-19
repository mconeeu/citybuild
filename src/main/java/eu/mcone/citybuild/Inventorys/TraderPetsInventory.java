package eu.mcone.citybuild.Inventorys;

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

public class TraderPetsInventory extends CoreInventory {

    public TraderPetsInventory(Player bp) {
        super("§8» §e§lHändler §8| §fSpawner", bp, InventorySlot.ROW_6);

        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(bp);

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


        setItem(
                InventorySlot.ROW_1_SLOT_1,
                new ItemBuilder(Material.IRON_SWORD, 1, 0)
                        .displayName("§c§lÜberlebungs-Items")
                        .lore("§7§oKaufe dir hier Überlebens Items.", "§7§oDie Items stehen dir danach in", "§7§odein Inventar zu verfügung.")
                        .create(),
                e -> {
                    bp.playSound(bp.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
                    new TraderInventory(bp);
                }
        );

        setItem(
                InventorySlot.ROW_2_SLOT_1,
                new ItemBuilder(Material.MONSTER_EGG, 1, 0)
                        .displayName("§c§lTierspawn-Items")
                        .lore("§7§oKaufe dir hier Tier Spawneggs.", "§7§oDie Items stehen dir danach in", "§7§odeinem Inventar zur Verfügung.")
                        .enchantment(Enchantment.DAMAGE_ALL, 5)
                        .unbreakable(true)
                        .itemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE)
                        .create(),
                e -> bp.playSound(bp.getLocation(), Sound.NOTE_BASS, 1, 1)
        );

        setItem(
                InventorySlot.ROW_3_SLOT_1,
                new ItemBuilder(Material.BREAD, 1, 0)
                        .displayName("§c§lEss-Items")
                        .lore("§7§oKaufe dir hier Essen.", "§7§oDie Items stehen dir danach in", "§7§odein Inventar zu verfügung.")
                        .create(),
                e -> {
                    bp.playSound(bp.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
                    new TraderEatInventory(bp);
                }
        );

        setItem(
                InventorySlot.ROW_4_SLOT_1,
                new ItemBuilder(Material.ENCHANTMENT_TABLE, 1, 0)
                        .displayName("§c§lExklusive-Items")
                        .lore("§7§oKaufe dir hier Exklusive Items.", "§7§oDie Items stehen dir danach in", "§7§odein Inventar zu verfügung.")
                        .create(),
                e -> {
                    bp.playSound(bp.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
                    new TraderExclusiveItems(bp);
                }
        );

        setItem(
                InventorySlot.ROW_5_SLOT_1,
                new ItemBuilder(Material.ARROW, 1, 0)
                        .displayName("§c§lMarkt-Liste")
                        .lore("§7§oGucke dir hier", "§7§oDie Preise der Aktuellen", "§7§oItems  an.")
                        .create(),
                e -> {
                    bp.playSound(bp.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
                    new AdverisingModeInventory(bp);
                }
        );


        setItem(
                InventorySlot.ROW_2_SLOT_3,
                new ItemBuilder(Material.MONSTER_EGG, 1, 93)
                        .displayName("§d§lHuhn-SpawnEi")
                        .lore("", "§6§o5.000 Coins")
                        .create(),
                e -> {
                    if ((cp.getCoins() - 5000) >= 0) {
                        cp.removeCoins(5000);
                        bp.getInventory().addItem(new ItemBuilder(Material.MONSTER_EGG, 1, 93).displayName("§dHuhn-SpawnEi").create());

                        bp.playSound(bp.getLocation(), Sound.LEVEL_UP, 1, 1);
                        bp.closeInventory();
                    } else {
                        bp.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast nicht genügend Coins");
                    }
                }
        );

        setItem(
                InventorySlot.ROW_2_SLOT_4,
                new ItemBuilder(Material.MONSTER_EGG, 1, 92)
                        .displayName("§a§lKuh-SpawnEi")
                        .lore("", "§6§o30.000 Coins")
                        .create(),
                e -> {
                    if ((cp.getCoins() - 30000) >= 0) {
                        cp.removeCoins(30000);
                        bp.getInventory().addItem(new ItemBuilder(Material.MONSTER_EGG, 1, 92).displayName("§aKuh-SpawnEi").create());

                        bp.playSound(bp.getLocation(), Sound.LEVEL_UP, 1, 1);
                        bp.closeInventory();
                    } else {
                        bp.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast nicht genügend Coins");
                    }
                }
        );

        setItem(
                InventorySlot.ROW_2_SLOT_5,
                new ItemBuilder(Material.MONSTER_EGG, 1, 90)
                        .displayName("§5§lSchwein-SpawnEi")
                        .lore("", "§6§o15.000 Coins")
                        .create(),
                e -> {
                    if ((cp.getCoins() - 15000) >= 0) {
                        cp.removeCoins(15000);
                        bp.getInventory().addItem(new ItemBuilder(Material.MONSTER_EGG, 1, 90).displayName("§5Schwein-SpawnEi").create());

                        bp.playSound(bp.getLocation(), Sound.LEVEL_UP, 1, 1);
                        bp.closeInventory();
                    } else {
                        bp.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast nicht genügend Coins");
                    }
                }
        );

        setItem(
                InventorySlot.ROW_2_SLOT_6, new ItemBuilder(Material.MONSTER_EGG, 1, 55).displayName("§5§lSlime-SpawnEi").lore("", "§6§o200.000 Coins").create(),
                e -> {
                    if ((cp.getCoins() - 200000) >= 0) {
                        cp.removeCoins(200000);
                        bp.getInventory().addItem(new ItemBuilder(Material.MONSTER_EGG, 1, 55).displayName("§5Slime-SpawnEi").create());

                        bp.playSound(bp.getLocation(), Sound.LEVEL_UP, 1, 1);
                        bp.closeInventory();
                    } else {
                        bp.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast nicht genügend Coins");
                    }
                }
        );

        setItem(
                InventorySlot.ROW_2_SLOT_7,
                new ItemBuilder(Material.MONSTER_EGG, 1, 120)
                        .displayName("§b§lVillager-SpawnEi")
                        .lore("", "§6§o100.000 Coins")
                        .create(),
                e -> {

                    if ((cp.getCoins() - 100000) >= 0) {
                        cp.removeCoins(100000);
                        bp.getInventory().addItem(new ItemBuilder(Material.MONSTER_EGG, 1, 120).displayName("§bVillager-SpawnEi").create());

                        bp.closeInventory();
                        bp.playSound(bp.getLocation(), Sound.LEVEL_UP, 1, 1);
                    } else {
                        bp.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast nicht genügend Coins");
                    }
                }
        );

        setItem(
                InventorySlot.ROW_2_SLOT_8,
                new ItemBuilder(Material.MONSTER_EGG, 1, 68)
                        .displayName("§5§lWächter-SpawnEi")
                        .lore("", "§6§o400.000 Coins")
                        .create(),
                e -> {
                    if ((cp.getCoins() - 400000) >= 0) {
                        cp.removeCoins(400000);
                        bp.getInventory().addItem(new ItemBuilder(Material.MONSTER_EGG, 1, 68).displayName("§5Wächter-SpawnEi").create());
                        bp.playSound(bp.getLocation(), Sound.LEVEL_UP, 1, 1);

                        bp.closeInventory();

                    } else {
                        bp.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast nicht genügend Coins");
                    }
                }
        );

        setItem(
                InventorySlot.ROW_3_SLOT_3,
                new ItemBuilder(Material.MONSTER_EGG, 1, 58)
                        .displayName("§5§lEnderman-SpawnEi")
                        .lore("", "§6§o300.000 Coins")
                        .create(),
                e -> {

                    if ((cp.getCoins() - 300000) >= 0) {
                        cp.removeCoins(300000);
                        bp.getInventory().addItem(new ItemBuilder(Material.MONSTER_EGG, 1, 58).displayName("§5Enderman-SpawnEi").create());

                        bp.closeInventory();
                        bp.playSound(bp.getLocation(), Sound.LEVEL_UP, 1, 1);
                    } else {
                        bp.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast nicht genügend Coins");
                    }
                }
        );


        openInventory();


    }
}
