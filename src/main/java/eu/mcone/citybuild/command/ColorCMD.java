/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.command;

import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import org.bukkit.entity.Player;

public class ColorCMD extends CorePlayerCommand {

    public ColorCMD() {
        super("color", null, "chatcolor");
    }

    @Override
    public boolean onPlayerCommand(Player player, String[] strings) {
        return false;
    }

}
