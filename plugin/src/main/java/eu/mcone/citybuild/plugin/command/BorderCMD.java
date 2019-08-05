/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.plugin.command;

import com.intellectualcrafters.plot.object.Plot;
import com.intellectualcrafters.plot.object.PlotPlayer;
import eu.mcone.citybuild.plugin.Citybuild;
import eu.mcone.citybuild.plugin.Inventorys.border.BorderInventory;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import org.bukkit.entity.Player;

public class BorderCMD extends CorePlayerCommand {

    public BorderCMD() {
        super("border", null, "rand");
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] args) {
        Plot plot = PlotPlayer.wrap(p).getCurrentPlot();

        if (plot != null) {
            if (plot.getOwners().contains(p.getUniqueId()) || p.hasPermission("citybuild.rand")) {
                new BorderInventory(p, plot);
            } else {
                Citybuild.getInstance().getMessager().send(p, "§4Du bist kein Owner dieses Plots!");
            }
        } else {
            Citybuild.getInstance().getMessager().send(p, "§4Du stehst auf keinem Plot!");
        }

        return false;
    }

}
