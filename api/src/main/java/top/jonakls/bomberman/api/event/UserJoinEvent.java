package top.jonakls.bomberman.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class UserJoinEvent extends Event {

    private final static HandlerList HANDLER_LIST = new HandlerList();
    private final Player uuid;
    private final String arena;

    public UserJoinEvent(Player uuid, String arena) {
        this.uuid = uuid;
        this.arena = arena;
    }

    public Player getUuid() {
        return uuid;
    }

    public String getArena() {
        return arena;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}
