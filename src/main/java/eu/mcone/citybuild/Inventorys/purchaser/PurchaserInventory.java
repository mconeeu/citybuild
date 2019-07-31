package eu.mcone.citybuild.Inventorys.purchaser;

import eu.mcone.citybuild.Inventorys.advertising.AdverisingModeInventory;
import eu.mcone.citybuild.Inventorys.advertising.AdverisingModeLevelInventory;
import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventoryOption;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.coresystem.api.bukkit.item.Skull;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class PurchaserInventory extends CoreInventory {


    public PurchaserInventory(Player p) {
        super("§f§lAnKäufer", p, InventorySlot.ROW_4, InventoryOption.FILL_EMPTY_SLOTS);

        setItem(InventorySlot.ROW_1_SLOT_5, Skull.fromUrl("http://textures.minecraft.net/texture/5163dafac1d91a8c91db576caac784336791a6e18d8f7f62778fc47bf146b6", 1).toItemBuilder()
                .displayName("§f§lAnKäufer")
                .lore("§7§oBeim AnKäufer kannst du bestimmnte Blöcke",
                        "§7§oFür Geld, Stackweise verkaufen!.",
                        "§7§oEr kauft: Alle Holz Arten, Cleanstone,",
                        "§7§oBruchstein und Sand für ein bestimmnnten Preis!"
                ).create());


        setItem(InventorySlot.ROW_3_SLOT_3, new ItemBuilder(Material.STONE, 64).displayName("§5§lVerkaufe Bruchstein")
                .lore("§7Verkaufe 1 Stackbruchstein", "§7für §a" + Items.STONE.getCoins() + "§7 Coins!")
                .create(), e -> {
            p.closeInventory();
            p.sendMessage("§8[§7§l!§8] §fServer §8» §cNehme 1 Stack Bruchstein in die Hand und interagiere mit dem AnKäufer!");
        


        });

        setItem(InventorySlot.ROW_4_SLOT_4, new ItemBuilder(Material.OAK_WOOD, 64).displayName("§5§lVerkaufe alle Holzsorten")
                .lore("§7Verkaufe 1 Stack Holzsorten", "§7für §a" + Items.OAK_WOOD.getCoins() + "§7 Coins!")
                .create(), e -> {
            p.closeInventory();
            p.sendMessage("§8[§7§l!§8] §fServer §8» §cNehme 1 Stack beliebiege Holzsorten in die Hand und interagiere mit dem AnKäufer!");



        });

        setItem(InventorySlot.ROW_4_SLOT_6, new ItemBuilder(Material.SAND, 64).displayName("§5§lVerkaufe Sand")
                .lore("§7Verkaufe 1 Stack Sand", "§7für §a" + Items.SAND.getCoins() + "§7 Coins!")
                .create(), e -> {
            p.closeInventory();
            p.sendMessage("§8[§7§l!§8] §fServer §8» §cNehme 1 Stack Sand in die Hand und interagiere mit dem AnKäufer!");



        });

        setItem(InventorySlot.ROW_3_SLOT_8, new ItemBuilder(Material.COBBLESTONE, 64).displayName("§5§lVerkaufe Bruchstein")
                .lore("§7Verkaufe 1 Stack Bruchstein", "§7für §a" + Items.COBBLESTONE.getCoins() + "§7 Coins!")
                .create(), e -> {
            p.closeInventory();
            p.sendMessage("§8[§7§l!§8] §fServer §8» §cNehme 1 Bruchstein Sand in die Hand und interagiere mit dem AnKäufer!");



        });


        openInventory();
    }

    @Getter
    public enum Items {
        STONE("§fStein", 300, new ItemBuilder(Material.STONE, 64).create()),
        OAK_WOOD("§fEichenholz", 250, new ItemBuilder(Material.OAK_WOOD, 64).create()),
        SPRUCE_WOOD("§fFichtenholz", 250, new ItemBuilder(Material.SPRUCE_WOOD, 64).create()),
        JUNGLE_WOOD("§fJungleholz", 250, new ItemBuilder(Material.JUNGLE_WOOD, 64).create()),
        BIRCH_WOOD("§fBirkenholz", 250, new ItemBuilder(Material.BIRCH_WOOD, 64).create()),
        ACACIA_WOOD("§fAkazienholz", 250, new ItemBuilder(Material.ACACIA_WOOD, 64).create()),
        DARK_OAK_WOOD("§fDunkles Eichenholz", 250, new ItemBuilder(Material.DARK_OAK_WOOD, 64).create()),
        COBBLESTONE("§fCobbleStone", 250, new ItemBuilder(Material.OAK_WOOD, 64).create()),
        SAND("§fSand", 200, new ItemBuilder(Material.SAND, 64).create());


        private final String displayName;
        private final int coins;
        private final ItemStack itemToSell;

        Items(final String displayName, final int coins, ItemStack itemToSell) {
            this.displayName = displayName;

            this.coins = coins;
            this.itemToSell = itemToSell;
        }
    }
}
