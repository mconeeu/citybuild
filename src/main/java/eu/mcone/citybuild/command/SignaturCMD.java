package eu.mcone.citybuild.command;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SignaturCMD extends CorePlayerCommand {

    public SignaturCMD() {
        super("sign");
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] args) {

        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);


        if (cp.getCoins() - 1000 >= 0) {
            if (p.getItemInHand() != null && !p.getItemInHand().getType().equals(Material.AIR)) {
                ItemStack i = p.getItemInHand();
                ItemMeta meta = i.hasItemMeta() ? i.getItemMeta() : Bukkit.getItemFactory().getItemMeta(i.getType());

                if (!meta.hasLore() || meta.getLore().size() == 0) {
                    List<String> lore = new ArrayList<>();
                    lore.add("§fDas Item wurde Signiert von " + cp.getMainGroup().getPrefix() + p.getName()+ " §fam §7"+ new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
                    meta.setLore(lore);

                    i.setItemMeta(meta);

                    cp.removeCoins(1000);
                    p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast das Item §aerfolgreich §7signiert");

                } else {
                    p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Das Item ist schon signiert");
                }
            } else {
                p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast kein Item in der Hand");
            }
        } else {
            p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast nicht genügend Coins");
        }

        return false;
    }

}
