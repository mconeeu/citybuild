package eu.mcone.citybuild.player;

import lombok.Getter;
import org.bukkit.Material;

@Getter
public enum Perk {

    NO_FALL_DAMAGE("§dKein Fallschaden", Material.DIAMOND_BOOTS, new String[]{""}, "citybuild.perks.falldamage"),
    KEEP_XP_ON_DEATH("§dXP nach Tod behalten", Material.EXP_BOTTLE, new String[]{""}, "citybuild.perks.keepxp"),
    PLOT_FLY("§dPlot-Fliegen", Material.FEATHER, new String[]{""}, "citybuild.perks.fly"),
    BREAK_BLOCK("§dBaue unzerstörbare Blöcke ab", Material.BEDROCK, new String[]{""}, "citybuild.perks.blockbreak"),
    KEEP_INVENTORY_ON_DEATH("§dInventar nach Tod behalten", Material.CHEST, new String[]{""}, "citybuild.perks.keepxp"),
    WATER_BREATHING("§dUnterwasseratmen", Material.WATER_BUCKET, new String[]{""}, "citybuild.perks.aqua");

    private String displayname, permission;
    private Material material;
    private String[] lore;

    Perk(String displayname, Material material, String[] lore, String permission) {
        this.displayname = displayname;
        this.material = material;
        this.lore = lore;
        this.permission = permission;
    }

}
