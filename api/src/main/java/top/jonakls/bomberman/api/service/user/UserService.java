package top.jonakls.bomberman.api.service.user;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import top.jonakls.bomberman.api.model.user.UserModel;
import top.jonakls.bomberman.api.service.Service;

import java.util.Optional;
import java.util.UUID;

public interface UserService extends Service {

    void load(String id);

    void unload(String id);

    default void load(UUID uuid) {
        load(uuid.toString());
    }

    default void load(Player player) {
        load(player.getUniqueId().toString());
    }

    default void unload(Player player) {
        unload(player.getUniqueId().toString());
    }

    default void unloadAll() {
        Bukkit.getOnlinePlayers().forEach(this::unload);
    }

    UserModel find(String id);

    UserModel create(Player player);

    default UserModel findOrCreate(Player player) {
        return find(player.getUniqueId().toString()) == null ? create(player) : find(player.getUniqueId().toString());
    }

    default UserModel findByUuid(UUID uuid) {
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) {
            throw new IllegalArgumentException("Player with uuid " + uuid + " is not online");
        }

        return findOrCreate(player);
    }

    Optional<UserModel> optionalFind(String id);

    void save(UserModel user);

    void delete(String id);

    void update(UserModel user);
}
