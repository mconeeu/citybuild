/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.api.item;

import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

@Getter
public enum ShopItem {

    STONE_SWORD(new ItemBuilder(Material.STONE_SWORD).displayName("§f§lStein-Schwert").enchantment(Enchantment.DAMAGE_ALL, 1), new String[]{"", "§6§o50 Coins"}, 50, ShopCategory.SURVIVAL),
    STONE_PICKAXE(new ItemBuilder(Material.STONE_PICKAXE).displayName("§f§lStein-Spitzhacke"), new String[]{"", "§6§o50 Coins"}, 50, ShopCategory.SURVIVAL),
    STONE_HOE(new ItemBuilder(Material.STONE_HOE).displayName("§f§lStein-Sense"), new String[]{"", "§6§o50 Coins"}, 50, ShopCategory.SURVIVAL),
    STONE_AXE(new ItemBuilder(Material.STONE_AXE).displayName("§f§lStein-Axt"), new String[]{"", "§6§o100 Coins"}, 100, ShopCategory.SURVIVAL),
    STONE_SPADE(new ItemBuilder(Material.STONE_SHOVEL).displayName("§f§lStein-Schaufel"), new String[]{"", "§6§o100 Coins"}, 100, ShopCategory.SURVIVAL),

    CHICKEN(new ItemBuilder(Material.CHICKEN_SPAWN_EGG, 1).displayName("§dHuhn-SpawnEi"), new String[]{"", "§6§o5.000 Coins"}, 5000, ShopCategory.SPAWN_EGGS),
    COW(new ItemBuilder(Material.COW_SPAWN_EGG, 1).displayName("§aKuh-SpawnEi"), new String[]{"", "§6§o30.000 Coins"}, 30000, ShopCategory.SPAWN_EGGS),
    PIG(new ItemBuilder(Material.PIG_SPAWN_EGG, 1).displayName("§5Schwein-SpawnEi"), new String[]{"", "§6§o15.000 Coins"}, 15000, ShopCategory.SPAWN_EGGS),
    SLIME(new ItemBuilder(Material.SLIME_SPAWN_EGG, 1).displayName("§5§lSlime-SpawnEi"), new String[]{"", "§6§o200.000 Coins"}, 200000, ShopCategory.SPAWN_EGGS),
    VILLAGER(new ItemBuilder(Material.VILLAGER_SPAWN_EGG, 1).displayName("§bVillager-SpawnEi"), new String[]{"", "§6§o100.000 Coins"}, 100000, ShopCategory.SPAWN_EGGS),
    GUARDIAN(new ItemBuilder(Material.GUARDIAN_SPAWN_EGG, 1).displayName("§5Wächter-SpawnEi"), new String[]{"", "§6§o400.000 Coins"}, 400000, ShopCategory.SPAWN_EGGS),
    ENDERMAN(new ItemBuilder(Material.ENDERMAN_SPAWN_EGG, 1, (short) 58).displayName("§5Enderman-SpawnEi"), new String[]{"", "§6§o300.000 Coins"}, 300000, ShopCategory.SPAWN_EGGS),

    BREAD(new ItemBuilder(Material.BREAD).displayName("§f§l32x Brot"), new String[]{"", "§6§o25 Coins"}, 25, ShopCategory.FOOD),
    CAKE(new ItemBuilder(Material.CAKE).displayName("§f§l32x Kuchen"), new String[]{"", "§6§o100 Coins"}, 100, ShopCategory.FOOD),
    BEEF(new ItemBuilder(Material.COOKED_BEEF).displayName("§f§l32x Steak"), new String[]{"", "§6§o150 Coins"}, 150, ShopCategory.FOOD),

    MOB_SPAWNER(new ItemBuilder(Material.SPAWNER).displayName("§c§lMobSpawner"), new String[]{"", "§6§o5.000.000 Coins"}, 5000000, ShopCategory.EXCLUSIVE),
    BEACON(new ItemBuilder(Material.BEACON).displayName("§b§lBeacon"), new String[]{"", "§6§o45.000 Coins"}, 45000, ShopCategory.EXCLUSIVE),
    DRAGON_EGG(new ItemBuilder(Material.DRAGON_EGG).displayName("§5§lDrachenEI"), new String[]{"", "§6§o500.000 Coins"}, 500000, ShopCategory.EXCLUSIVE);

    private ItemBuilder rawItem;
    private String[] shopLore;
    private int price;
    private ShopCategory category;

    ShopItem(ItemBuilder rawItem, String[] shopLore, int price, ShopCategory category) {
        this.rawItem = rawItem;
        this.shopLore = shopLore;
        this.price = price;
        this.category = category;
    }

}
