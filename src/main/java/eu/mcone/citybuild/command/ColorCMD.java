/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.command;

import eu.mcone.citybuild.Inventorys.ChatInventory;
import eu.mcone.citybuild.Inventorys.trader.TraderSurvivalInventory;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ColorCMD extends CorePlayerCommand {

    public ColorCMD() {
        super("color");
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] args) {

        new ChatInventory(p);

        return false;
    }
}