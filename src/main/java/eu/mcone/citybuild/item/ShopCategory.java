/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.item;

import eu.mcone.citybuild.Inventorys.trader.*;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@Getter
public enum ShopCategory {

    SURVIVAL("Überlebens-Items", Material.IRON_SWORD, new String[]{"§7§oKaufe dir hier Überlebens Items.", "§7§oDie Items stehen dir danach in", "§7§odein Inventar zu verfügung."}, TraderSurvivalInventory.class),
    SPAWN_EGGS("Tierspawn-Items", Material.MONSTER_EGG, new String[]{"§7§oKaufe dir hier Tier Spawneggs.", "§7§oDie Items stehen dir danach in", "§7§odeinem Inventar zur Verfügung."}, TraderSpawnEggsInventory.class),
    FOOD("Ess-Items", Material.BREAD, new String[]{"§7§oKaufe dir hier Essen.", "§7§oDie Items stehen dir danach in", "§7§odein Inventar zu verfügung."}, TraderFoodInventory.class),
    EXCLUSIVE("Exklusive-Items", Material.ENCHANTMENT_TABLE, new String[]{"§7§oKaufe dir hier Exklusive Items.", "§7§oDie Items stehen dir danach in", "§7§odein Inventar zu verfügung."}, TraderExclusiveInventory.class),
    MARKETPLACE("Markt-Liste", Material.ARROW, new String[]{"§7§oGucke dir hier", "§7§oDie Preise der Aktuellen", "§7§oItems  an."}, TraderMarketplaceInventory.class),
    PERKS("Perks", Material.STICK, new String[]{"§7§oKaufe dir hier", "§7§oPerks", "§7§ofür Exklusiven Spiel spaß!."}, TraderPerksInventory.class),
    RANK("Ränge", Material.LEATHER_BOOTS, new String[]{}, TraderRankInventory.class),
    ITEM_LIST("Itemliste", Material.BOOK, new String[]{}, TraderItemListInventory.class);

    private String name;
    private Material material;
    private String[] lore;
    private Class<? extends TraderInventory> invClass;

    ShopCategory(String name, Material material, String[] lore, Class<? extends TraderInventory> invClass) {
        this.name = name;
        this.material = material;
        this.lore = lore;
        this.invClass = invClass;
    }

    public String getLabel() {
        return "§c§l"+ name;
    }

    public ItemStack getItem() {
        return new ItemBuilder(material).displayName(getLabel()).lore(lore).create();
    }

}
