package eu.mcone.citybuild.command;

import com.intellectualcrafters.plot.object.Plot;
import com.intellectualcrafters.plot.object.PlotPlayer;
import eu.mcone.citybuild.Citybuild;
import eu.mcone.citybuild.Inventorys.BorderInventory;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import org.bukkit.entity.Player;

public class BorderCMD extends CorePlayerCommand {

    public BorderCMD() {
        super("border", null, "rand");
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] strings) {
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
