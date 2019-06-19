package eu.mcone.citybuild.listener;

import eu.mcone.citybuild.Citybuild;
import eu.mcone.citybuild.player.CitybuildPlayer;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.core.player.Group;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

public class PlayerChatListener implements Listener {

    @EventHandler
    public void on(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);
        CitybuildPlayer cbp = Citybuild.getInstance().getCitybuildPlayer(p.getUniqueId());
        String message;

        if (cp.isNicked()) {
            message = Group.SPIELER.getPrefix() + CoreSystem.getInstance().getTranslationManager().get("system.bukkit.chat")
                    .replaceAll("%Player%", p.getName())
                    .replaceAll("Nachricht", e.getMessage());
        } else {
            message = cp.getMainGroup().getPrefix() + CoreSystem.getInstance().getTranslationManager().get("system.bukkit.chat")
                    .replaceAll("%Player%", p.getName())
                    .replaceAll("Nachricht", e.getMessage());
        }

        if (cbp.getDefaultChatColor() != ChatColor.GRAY) {
            message = message + cbp.getDefaultChatColor().toString();
        }

        if (p.hasPermission("citybuild.chat.color")) {
            message = ChatColor.translateAlternateColorCodes('&', message);
        }

        String playerMessage = message;
        for (Player receiver : Bukkit.getOnlinePlayers()) {
            if (receiver != p) {
                String targetMessage;

                if (message.contains(receiver.getName())) {
                    if (message.contains("@" + receiver.getName())) {
                        targetMessage = message.replaceAll("@" + receiver.getName(), "§b@" + receiver.getName() + "§7");
                        playerMessage = playerMessage.replaceAll("@" + receiver.getName(), ChatColor.AQUA + "@" + receiver.getName() + ChatColor.GRAY);
                    } else {
                        targetMessage = message.replaceAll(receiver.getName(), "§b@" + receiver.getName() + "§7");
                        playerMessage = playerMessage.replaceAll(receiver.getName(), "§b@" + receiver.getName() + "§7");
                    }

                    e.getRecipients().remove(receiver);
                    receiver.sendMessage(targetMessage);
                    receiver.playSound(receiver.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
                }
            }
        }

        e.setFormat(message);

        e.getRecipients().remove(p);
        p.sendMessage(playerMessage);
    }
}
