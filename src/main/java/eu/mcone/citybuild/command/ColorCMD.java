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
