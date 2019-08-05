/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.plugin.command;

import eu.mcone.citybuild.plugin.Citybuild;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SignCMD extends CorePlayerCommand {

    public SignCMD() {
        super("sign");
        CoreSystem.getInstance().getCooldownSystem().setCustomCooldownFor(getClass(), 180);
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] args) {
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

        if (!p.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
            ItemStack i = p.getInventory().getItemInMainHand();
            ItemMeta meta = i.hasItemMeta() ? i.getItemMeta() : Bukkit.getItemFactory().getItemMeta(i.getType());

            if (meta != null && !meta.hasLore()) {
                List<String> lore = new ArrayList<>();
                lore.add("§fDas Item wurde Signiert von " + cp.getMainGroup().getPrefix() + p.getName() + " §fam §7" + new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
                meta.setLore(lore);

                i.setItemMeta(meta);

                Citybuild.getInstance().getMessager().send(p, "§2Du hast das Item erfolgreich signiert");
            } else {
                Citybuild.getInstance().getMessager().send(p, "§4Das Item ist bereits signiert, kauf dir eine Brille!");
            }
        } else {
            Citybuild.getInstance().getMessager().send(p, "§4Du hast kein Item in der Hand");
        }


        return false;
    }

}
