/*
 * Copyright (c) 2019 Marvin Hülsmann, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.citybuild.command;

import eu.mcone.citybuild.Citybuild;
import eu.mcone.citybuild.scheduler.WorldReset;
import eu.mcone.coresystem.api.bukkit.command.CorePlayerCommand;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FarmWorldCMD extends CorePlayerCommand {

    public FarmWorldCMD() {
        super("farmwelt", null, "farmworld", "farm");
    }

    @Override
    public boolean onPlayerCommand(Player p, String[] strings) {
        CoreWorld w = Citybuild.getInstance().getFarmWorld();

        if (w != null) {
            w.teleportSilently(p, "spawn");
            Citybuild.getInstance().getMessager().send(
                    p,
                    "§7Die Farmwelt wird am §f" + new SimpleDateFormat("dd.MM.yyyy").format(new Date(WorldReset.getNextReset() * 1000)) +
                            "§7 zwischen §f" + new SimpleDateFormat("HH:mm").format(new Date(WorldReset.getNextReset() * 1000)) +
                            "§7 und §f" + new SimpleDateFormat("HH:mm").format(new Date((WorldReset.getNextReset() + 60 * 60) * 1000)) +
                            "§7 zurückgesetzt!"
            );
        } else {
            Citybuild.getInstance().getMessager().send(p, "§4Bitte warte noch einen Moment! Die Farmwelt wird gerade zurückgesetzt!");
        }

        return true;
    }
}
