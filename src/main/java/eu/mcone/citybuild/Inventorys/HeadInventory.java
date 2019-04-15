package eu.mcone.citybuild.Inventorys;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class HeadInventory extends CoreInventory {

    public HeadInventory(Player p, String playername) {
        super("§f§lKopf Kauf von " + playername, p, InventorySlot.ROW_1, Option.FILL_EMPTY_SLOTS);

        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        setItem(InventorySlot.ROW_1_SLOT_5, ItemBuilder.createSkullItem(playername, 1).create());


        setItem(InventorySlot.ROW_1_SLOT_7, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 5).displayName("§a§lKaufen").lore("§6§o25.000 Coins").create(),
                e -> {

                    if (cp.getCoins() - 25000 >= 0) {
                        cp.removeCoins(25000);
                        cp.getScoreboard().reload();
                        p.getInventory().addItem(ItemBuilder.createSkullItem(playername, 1).displayName("§f§l" + playername + "´s Kopf").create());

                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                        p.sendMessage("§8[§7§l!§8] §fSystem §8» §aDu hast das Item erfolgreich gekauft");
                    } else {
                        p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast nicht genügend Coins!");
                    }

                });

        setItem(InventorySlot.ROW_1_SLOT_3, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 14).displayName("§c§lAbbrechen").lore("§6§oBreche den Kauf ab").create(),
                e -> {


                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.NOTE_BASS, 1, 1);
                    p.sendMessage("§8[§7§l!§8] §fSystem §8» §cDu hast erfolgreich abgebrochen");


                });

        openInventory();
    }

}
