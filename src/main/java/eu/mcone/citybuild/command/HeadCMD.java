package eu.mcone.citybuild.command;

import eu.mcone.citybuild.Inventorys.HeadInventory;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import org.bukkit.entity.Player;

public class HeadCMD extends CorePlayerCommand {

    public HeadCMD() {
        super("head");
        CoreSystem.getInstance().getCooldownSystem().setCustomCooldownFor(getClass(), 120);
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] args) {
        if (args.length == 0) {
            p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Bitte benutze /head [name]");
            return true;
        }

        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);
        if ((cp.getCoins() - 25000) >= 0) {
            new HeadInventory(p, args[0]);
        } else {
            p.sendMessage("§8[§7§l!§8] §fSystem §8» §7Du hast nicht genügend Coins");
        }

        return false;
    }
}
