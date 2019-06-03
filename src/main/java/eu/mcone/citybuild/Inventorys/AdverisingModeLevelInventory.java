package eu.mcone.citybuild.Inventorys;

import eu.mcone.citybuild.Citybuild;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.coresystem.api.bukkit.inventory.anvil.AnvilSlot;
import eu.mcone.coresystem.api.bukkit.inventory.anvil.CoreAnvilInventory;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.util.ItemBuilder;
import lombok.AllArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AdverisingModeLevelInventory extends CoreInventory {

    private final static Map<UUID, ModeLevelMsg> players = new HashMap<>();

    private static final CoreAnvilInventory ANVIL_MSG_INVENTORY = CoreSystem.getInstance().createAnvilInventory(e -> {
        Player p = e.getPlayer();

        if (e.getSlot().equals(AnvilSlot.OUTPUT)) {
            String msg = e.getName();
            ModeLevelMsg modeLevelMsg = players.get(p.getUniqueId());
            modeLevelMsg.msg = msg;

            openAnvilInventory(p, modeLevelMsg);
        }
    });

    private static final CoreAnvilInventory ANVIL_NAME_INVENTORY = CoreSystem.getInstance().createAnvilInventory(e -> {
        Player p = e.getPlayer();
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        if (e.getSlot().equals(AnvilSlot.OUTPUT)) {
            String name = e.getName();

            if (name.length() <= 16) {
                Player t = Bukkit.getPlayer(name);

                if (t != null) {
                    ModeLevelMsg modeLevelMsg = players.get(p.getUniqueId());
                    if ((cp.getCoins() - modeLevelMsg.level.coins) >= 0) {
                        new AdvertisingConfirmInventory(p, t, modeLevelMsg);
                    } else {
                        Citybuild.getInstance().getMessager().send(p, "§4Du hast nicht genug Coins!");
                        p.closeInventory();
                    }
                } else {
                    p.playSound(p.getLocation(), Sound.NOTE_BASS, 1, 1);
                    e.getAnvilInventory().setItem(
                            AnvilSlot.OUTPUT.getSlot(),
                            new ItemBuilder(Material.BARRIER)
                                    .displayName("§c§lDer Spiele muss")
                                    .lore("§c§lonline sein!")
                                    .create()
                    );
                }
            } else {
                p.playSound(p.getLocation(), Sound.NOTE_BASS, 1, 1);
                e.getAnvilInventory().setItem(
                        AnvilSlot.OUTPUT.getSlot(),
                        new ItemBuilder(Material.BARRIER)
                                .displayName("§c§lDer Name darf nur")
                                .lore("§c§l20 Zeichen lang sein!")
                                .create()
                );
            }
        }
    });

    enum Level {
        DEFAULT(new ItemBuilder(Material.INK_SACK,1,8).displayName("§7Standard-Nachricht").lore("", "§7§oMit diesem Kauf erhälst du folgendes", "§6§oFür 1.000 Coins", "", "§7- §cEine gefärbte fette Nachricht").create(), 1000),
        EPIC(new ItemBuilder(Material.INK_SACK,1,5).displayName("§5Epische-Nachricht").lore("", "§7§oMit diesem Kauf erhälst du folgendes", "§6§oFür 3.000 Coins", "", "§7- §cEine gefärbte fette Nachricht", "§7- §cEine klickbare teleportations Nachricht").create(), 3000),
        EXCLUSIVE(new ItemBuilder(Material.INK_SACK, 1,14).displayName("§6Exklusive-Nachricht").lore("", "§7§oMit diesem Kauf erhälst du folgendes", "§6§oFür 5.000 Coins", "", "§7- §cEine gefärbte fette Nachricht", "§7- §cEine klickbare teleportations Nachricht", "§7- §cEine eigene Nachricht mit allen Farben und Speziellen Features").create(), 5000);

        ItemStack item;
        int coins;

        Level(ItemStack item, int coins) {
            this.item = item;
            this.coins = coins;
        }
    }

    @AllArgsConstructor
    final class ModeLevelMsg {
        AdverisingModeInventory.Mode mode;
        Level level;
        String msg;
    }

    public AdverisingModeLevelInventory(Player p, AdverisingModeInventory.Mode mode) {
        super("§f§lWähle dein Level Paket", p, InventorySlot.ROW_3);

        setItem(InventorySlot.ROW_2_SLOT_3, Level.DEFAULT.item, e -> openAnvilInventory(p, new ModeLevelMsg(mode, Level.DEFAULT, null)));

        setItem(InventorySlot.ROW_2_SLOT_5, Level.EPIC.item, e -> openAnvilInventory(p, new ModeLevelMsg(mode, Level.EPIC, null)));

        setItem(InventorySlot.ROW_2_SLOT_7, Level.EXCLUSIVE.item, e -> {
            players.put(p.getUniqueId(), new ModeLevelMsg(mode, Level.EXCLUSIVE, null));
            ANVIL_MSG_INVENTORY.open(p).setItem(AnvilSlot.INPUT_LEFT.getSlot(),  new ItemBuilder(Material.PAPER).displayName("Dein Werbungs Text").create());
        });

        openInventory();
    }

    private static void openAnvilInventory(Player p, ModeLevelMsg modeLevelMsg) {
        players.put(p.getUniqueId(), modeLevelMsg);
        ANVIL_NAME_INVENTORY
                .open(p)
                .setItem(AnvilSlot.INPUT_LEFT.getSlot(),
                        new ItemBuilder(Material.PAPER)
                                .displayName("Wähle den Spielername")
                                .create()
                );
    }

}
