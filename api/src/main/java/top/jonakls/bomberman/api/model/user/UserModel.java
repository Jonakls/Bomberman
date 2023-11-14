package top.jonakls.bomberman.api.model.user;

import org.bukkit.entity.Player;
import top.jonakls.bomberman.api.model.Model;
import top.jonakls.bomberman.api.model.user.stats.UserStats;

public class UserModel implements Model {

    private final String id;
    private String name;
    private UserStats stats;

    public UserModel(String id, String name) {
        this.id = id;
        this.name = name;
        this.stats = UserStats.empty();
    }

    public UserModel(String id, String name, UserStats stats) {
        this.id = id;
        this.name = name;
        this.stats = stats;
    }

    public static UserModel empty(Player player) {
        return new UserModel(player.getUniqueId().toString(), player.getName());
    }

    @Override
    public String id() {
        return this.id;
    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public UserStats stats() {
        return stats;
    }

    public void stats(UserStats stats) {
        this.stats = stats;
    }
}
