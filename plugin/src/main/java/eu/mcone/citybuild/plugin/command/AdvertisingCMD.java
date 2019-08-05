/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.plugin.command;

import eu.mcone.citybuild.plugin.Inventorys.advertising.AdverisingModeInventory;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import org.bukkit.entity.Player;

public class AdvertisingCMD extends CorePlayerCommand {

    public AdvertisingCMD() {
        super("werbung");
        CoreSystem.getInstance().getCooldownSystem().setCustomCooldownFor(getClass(), 190);
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] args) {
        new AdverisingModeInventory(p);
        return true;
    }
}
