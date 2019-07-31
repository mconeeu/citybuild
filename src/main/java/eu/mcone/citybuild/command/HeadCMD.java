/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.command;

import eu.mcone.citybuild.Citybuild;
import eu.mcone.citybuild.Inventorys.HeadInventory;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import org.bukkit.entity.Player;

public class HeadCMD extends CorePlayerCommand {

    public HeadCMD() {
        super("head");
        CoreSystem.getInstance().getCooldownSystem().setCustomCooldownFor(getClass(), 60);
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] args) {
        if (args.length == 0) {

            Citybuild.getInstance().getMessager().send(p, "§4Bitte benutze: §c/head <name>");
            return true;
        }

        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);
        if ((cp.getCoins() - 35000) >= 0) {
            new HeadInventory(p, args[0]);
        } else {
            Citybuild.getInstance().getMessager().send(p, "§4Du hast nicht genügend Coins!");
        }

        return false;
    }
}
