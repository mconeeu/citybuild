package eu.mcone.citybuild.api.event;

import eu.mcone.citybuild.api.player.CitybuildPlayer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@AllArgsConstructor
@Getter
public class CitybuildPlayerLoadedEvent extends Event {

    @Getter
    private final static HandlerList handlerList = new HandlerList();

    private CitybuildPlayer player;
    private Reason reason;

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public enum Reason {
        JOINED, RELOADED
    }
}
