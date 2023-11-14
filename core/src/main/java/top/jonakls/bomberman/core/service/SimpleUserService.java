package top.jonakls.bomberman.core.service;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import top.jonakls.bomberman.api.cache.ObjectCache;
import top.jonakls.bomberman.api.model.user.UserModel;
import top.jonakls.bomberman.api.service.user.UserService;
import top.jonakls.bomberman.api.storage.ObjectStorage;

import java.util.Optional;
import java.util.UUID;

public class SimpleUserService implements UserService {

    private final Logger logger;
    private final ObjectCache<UserModel> cache;
    private final ObjectStorage<UserModel> storage;

    private SimpleUserService(
            Plugin plugin,
            ObjectCache<UserModel> cache,
            ObjectStorage<UserModel> storage
    ) {
        this.logger = plugin.getSLF4JLogger();
        this.cache = cache;
        this.storage = storage;
    }

    public static SimpleUserService create(
            Plugin plugin,
            ObjectCache<UserModel> cache,
            ObjectStorage<UserModel> storage
    ) {
        return new SimpleUserService(plugin, cache, storage);
    }

    @Override
    public void load(String id) {
        UserModel userModel = this.find(id);
        if (userModel != null) {
            return;
        }

        this.storage.find(id).thenAccept(user -> {
            if (user != null) {
                this.cache.load(user);
            }
        }).exceptionally(throwable -> {
            if (throwable != null) {
                this.logger.error("Error while loading user with id " + id, throwable);
            }
            return null;
        });
    }

    @Override
    public void unload(String id) {
        UserModel userModel = this.find(id);
        if (userModel == null) {
            return;
        }

        this.storage.save(userModel).exceptionally(throwable -> {
            if (throwable != null) {
                this.logger.error("Error while saving user with id " + id, throwable);
            }
            return null;
        }).thenAccept(user -> {
            if (user != null) {
                this.cache.unload(user);
            }
        });
    }

    @Override
    @Nullable
    public UserModel find(String id) {
        return this.cache.optionalFind(UUID.fromString(id)).orElse(null);
    }

    @Override
    public UserModel create(Player player) {
        return UserModel.empty(player);
    }

    @Override
    public Optional<UserModel> optionalFind(String id) {
        return this.cache.optionalFind(UUID.fromString(id));
    }

    @Override
    public void save(UserModel user) {
        UserModel userModel = this.find(user.uuid().toString());
        if (userModel == null) {
            return;
        }

        this.storage.save(user).thenAccept(this.cache::replace).exceptionally(throwable -> {
            if (throwable != null) {
                this.logger.error("Error while saving user with id " + user.uuid().toString(), throwable);
            }
            return null;
        });
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(UserModel user) {

    }
}
