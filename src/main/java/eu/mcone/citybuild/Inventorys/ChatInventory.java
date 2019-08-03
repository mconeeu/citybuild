package eu.mcone.citybuild.Inventorys;

import eu.mcone.citybuild.Citybuild;
import eu.mcone.citybuild.player.CitybuildPlayer;
import eu.mcone.citybuild.util.CitybuildChatColor;
import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventoryOption;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ChatInventory extends CoreInventory {

    private static final Map<CitybuildChatColor, ItemBuilder> items = new HashMap<>();
    static {
        for (CitybuildChatColor color : CitybuildChatColor.values()) {
            items.put(color, new ItemBuilder(color.getMaterial()).displayName("§f§l"+color.getDisplayName()));
        }
    }

    public ChatInventory(Player p) {
        super("Chat", p, InventorySlot.ROW_3, InventoryOption.FILL_EMPTY_SLOTS);
        CitybuildPlayer cbp = Citybuild.getInstance().getCitybuildPlayer(p.getUniqueId());

        Iterator<Map.Entry<CitybuildChatColor, ItemBuilder>> it = items.entrySet().iterator();
        for (int i = 0, x = 1; i < items.size(); i++, x++) {
            if (x == 7) {
                x = 10;
            }

            Map.Entry<CitybuildChatColor, ItemBuilder> entry = it.next();
            setItem(x, entry.getValue().lore(cbp.hasChatColor(entry.getKey()) ? "§2§oDu besitz diese Farbe!" : "§4$oDu besitzt diese Farbe nicht!").create(), cbp.hasChatColor(entry.getKey()) ? e -> {
                cbp.setDefaultChatColor(entry.getKey().getColor());
                Citybuild.getInstance().getMessager().send(p, "§2Du hast die Farbe "+entry.getKey().getDisplayName()+" erfolgreich als Standartfarbe ausgewählt!");
            } : null);
        }
    }

}
