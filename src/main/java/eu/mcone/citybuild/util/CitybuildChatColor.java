package eu.mcone.citybuild.util;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Material;

@Getter
public enum CitybuildChatColor {

    GREEN(Material.LIME_DYE, ChatColor.GREEN, "Grün"),
    AQUA(Material.LIGHT_BLUE_DYE, ChatColor.AQUA, "Türkis"),
    RED(Material.ROSE_RED, ChatColor.RED, "Rot"),
    PURPLE(Material.MAGENTA_DYE, ChatColor.LIGHT_PURPLE, "Pink"),
    YELLOW(Material.DANDELION_YELLOW, ChatColor.YELLOW, "Gelb"),
    WHITE(Material.BONE_MEAL, ChatColor.WHITE, "Weiß"),

    DARK_BLUE(Material.LAPIS_LAZULI, ChatColor.DARK_BLUE, "Dunkelblau"),
    DARK_GREEN(Material.CACTUS_GREEN, ChatColor.DARK_GREEN, "Dunkelgrün"),
    DARK_CYAN(Material.CYAN_DYE, ChatColor.DARK_AQUA, "Dunkeltürkis"),
    DARK_RED(Material.BEETROOT, ChatColor.DARK_RED, "Dunkelrot"),
    DARK_PURPLE(Material.PURPLE_DYE, ChatColor.DARK_PURPLE, "Dunkelpink"),
    GOLD(Material.ORANGE_DYE, ChatColor.GOLD, "Dunkelgelb"),
    BLUE(Material.LIGHT_BLUE_DYE, ChatColor.BLUE, "Blau");

    private Material material;
    private ChatColor color;
    private String name;

    CitybuildChatColor(Material material, ChatColor color, String name) {
        this.material = material;
        this.color = color;
        this.name = name;
    }

    public String getDisplayName() {
        return color+name+"e Farbe";
    }

}
