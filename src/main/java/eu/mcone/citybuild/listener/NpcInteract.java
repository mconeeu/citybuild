package eu.mcone.citybuild.listener;

import eu.mcone.citybuild.Inventorys.TraderInventory;
import eu.mcone.coresystem.api.bukkit.event.NpcInteractEvent;
import eu.mcone.coresystem.api.bukkit.npc.NPC;
import net.minecraft.server.v1_8_R3.PacketPlayInUseEntity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import sun.applet.Main;

public class NpcInteract implements Listener {

    @EventHandler
    public void on(NpcInteractEvent e) {
        Player p = e.getPlayer();
        NPC npc = e.getNpc();

        if (e.getNpc().getData().getType().equals(EntityType.PLAYER) && e.getAction().equals(PacketPlayInUseEntity.EnumEntityUseAction.INTERACT)) {
            switch (npc.getData().getName()) {
                case "händlercb": {
                    new TraderInventory(p);
                    break;
                }
            }
        }
    }
}