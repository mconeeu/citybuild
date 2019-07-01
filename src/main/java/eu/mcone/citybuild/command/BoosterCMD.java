/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.command;

import eu.mcone.citybuild.Inventorys.border.BoosterInventory;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;

import org.bukkit.entity.Player;

public class BoosterCMD extends CorePlayerCommand {

    public BoosterCMD() {
        super("booster");
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] args) {
        new BoosterInventory(p);
        return true;
    }

}