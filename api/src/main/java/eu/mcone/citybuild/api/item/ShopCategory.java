/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.api.item;

import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@Getter
public enum ShopCategory {

    SURVIVAL("Überlebens-Items", Material.IRON_SWORD, new String[]{"§7§oKaufe dir hier Überlebens Items.", "§7§oDie Items stehen dir danach in", "§7§odein Inventar zu verfügung."}),
    SPAWN_EGGS("Tierspawn-Items", Material.PIG_SPAWN_EGG, new String[]{"§7§oKaufe dir hier Tier Spawneggs.", "§7§oDie Items stehen dir danach in", "§7§odeinem Inventar zur Verfügung."}),
    FOOD("Ess-Items", Material.BREAD, new String[]{"§7§oKaufe dir hier Essen.", "§7§oDie Items stehen dir danach in", "§7§odein Inventar zu verfügung."}),
    EXCLUSIVE("Exklusive-Items", Material.ENCHANTING_TABLE, new String[]{"§7§oKaufe dir hier Exklusive Items.", "§7§oDie Items stehen dir danach in", "§7§odein Inventar zu verfügung."}),
    MARKETPLACE("Markt-Liste", Material.BOOK, new String[]{"§7§o(EBAY SYSTEM)", "§7§oDie Preise der Aktuellen", "§7§oItems  an."}),
    PERKS("Perks", Material.STICK, new String[]{"§7§oKaufe dir hier", "§7§oPerks", "§7§ofür Exklusiven Spiel spaß!."});

    private String name;
    private Material material;
    private String[] lore;

    ShopCategory(String name, Material material, String[] lore) {
        this.name = name;
        this.material = material;
        this.lore = lore;
    }

    public String getLabel() {
        return "§c§l" + name;
    }

    public ItemStack getItem() {
        return new ItemBuilder(material).displayName(getLabel()).lore(lore).create();
    }

}
