/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.api.item;

import lombok.Getter;
import org.bukkit.Material;

@Getter
public enum Perk {

    NO_FALL_DAMAGE(1, PerkCategory.MOVEMENT, "§dKein Fallschaden", Material.DIAMOND_BOOTS, new String[]{""}, 100),
    KEEP_XP_ON_DEATH(2, PerkCategory.PLAYER, "§dXP nach Tod behalten", Material.EXPERIENCE_BOTTLE, new String[]{""}, 100),
    BREAK_BLOCK(4, PerkCategory.BUILD, "§dBaue unzerstörbare Blöcke ab", Material.BEDROCK, new String[]{""}, 100),
    KEEP_INVENTORY_ON_DEATH(5, PerkCategory.PLAYER, "§dInventar nach Tod behalten", Material.CHEST, new String[]{""}, 100),
    WATER_BREATHING(6, PerkCategory.EFFECT, "§dUnterwasseratmen", Material.WATER_BUCKET, new String[]{""}, 100),
    FIRE_RESISTANCE(7, PerkCategory.EFFECT, "§dKein Feuerschaden", Material.FIRE_CHARGE, new String[]{""}, 100),
    NIGHT_VISION(8, PerkCategory.EFFECT, "§dNachtsicht", Material.GLASS_BOTTLE, new String[]{""}, 100),
    SPEED(9, PerkCategory.MOVEMENT, "§dSchneller Laufen", Material.DIAMOND_BOOTS, new String[]{""}, 100),
    FOOD_SAVE(10, PerkCategory.PLAYER, "§dKein Hunger", Material.COOKED_BEEF, new String[]{""}, 100);

    private int id, price;
    private PerkCategory perkCategory;
    private String displayname;
    private Material material;
    private String[] lore;

    Perk(int id, PerkCategory perkCategory, String displayname, Material material, String[] lore, int price) {
        this.id = id;
        this.perkCategory = perkCategory;
        this.displayname = displayname;
        this.material = material;
        this.lore = lore;
        this.price = price;

    }

    public static Perk getPerkById(int id) {
        for (Perk perk : Perk.values()) {
            if (perk.id == id) {
                return perk;
            }
        }

        return null;
    }

    public enum PerkCategory {
        EFFECT(),
        MOVEMENT(),
        BUILD(),
        PLAYER()
    }
}
