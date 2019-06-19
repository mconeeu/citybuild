package eu.mcone.citybuild.Inventorys;

import eu.mcone.citybuild.player.Perk;
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

public class TraderPerksInventory extends CoreInventory {

    public TraderPerksInventory(Player p) {
        super("§8» §e§lHändler §8| §fPerks", p, InventorySlot.ROW_6);


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
                    new TraderInventory(p);
                    p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP,1,1);

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

                    p.playSound(p.getLocation(), Sound.NOTE_BASS, 1, 1);


                });


        ///////////////////////////////////////////







    }
}
