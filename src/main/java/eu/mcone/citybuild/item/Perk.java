/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.item;

import lombok.Getter;
import org.bukkit.Material;

@Getter
public enum Perk {

    NO_FALL_DAMAGE(1, "§dKein Fallschaden", Material.DIAMOND_BOOTS, new String[]{""}, 100, "citybuild.perks.falldamage"),
    KEEP_XP_ON_DEATH(2, "§dXP nach Tod behalten", Material.EXP_BOTTLE, new String[]{""}, 100, "citybuild.perks.keepxp"),
    PLOT_FLY(3, "§dPlot-Fliegen", Material.FEATHER, new String[]{""}, 100, "citybuild.perks.fly"),
    BREAK_BLOCK(4, "§dBaue unzerstörbare Blöcke ab", Material.BEDROCK, new String[]{""}, 100, "citybuild.perks.blockbreak"),
    KEEP_INVENTORY_ON_DEATH(5, "§dInventar nach Tod behalten", Material.CHEST, new String[]{""}, 100, "citybuild.perks.keepxp"),
    WATER_BREATHING(6, "§dUnterwasseratmen", Material.WATER_BUCKET, new String[]{""}, 100, "citybuild.perks.aqua");

    private int id, price;
    private String displayname, permission;
    private Material material;
    private String[] lore;

    Perk(int id, String displayname, Material material, String[] lore, int price, String permission) {
        this.id = id;
        this.displayname = displayname;
        this.material = material;
        this.lore = lore;
        this.price = price;
        this.permission = permission;
    }

    public static Perk getPerkById(int id) {
        for (Perk perk : Perk.values()) {
            if (perk.id == id) {
                return perk;
            }
        }

        return null;
    }

}
