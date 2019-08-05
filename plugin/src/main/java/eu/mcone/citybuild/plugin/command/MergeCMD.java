/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.plugin.command;

import eu.mcone.coresystem.api.bukkit.command.CoreCommand;
import org.bukkit.command.CommandSender;

public class MergeCMD extends CoreCommand {

    public MergeCMD() {
        super("merge");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, String[] strings) {
        return true;
    }

}
