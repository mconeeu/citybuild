/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.command;

import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class CraftCMD extends CorePlayerCommand {

    public CraftCMD() {
        super("craft");
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] args) {
        p.openWorkbench(null, true);
        p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 1, 1);
        return true;
    }
}
