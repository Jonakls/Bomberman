package top.jonakls.bomberman.api.cache;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.jonakls.bomberman.api.model.Model;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ObjectCache<T extends Model> implements Iterable<T> {

    private final Map<UUID, T> cache = new ConcurrentHashMap<>();

    public void load(T object) {
        this.cache.put(object.uuid(), object);
    }

    public void unload(T object) {
        this.cache.remove(object.uuid());
    }

    @Nullable
    public T find(UUID uuid) {
        return this.cache.get(uuid);
    }

    @NotNull
    public Optional<T> optionalFind(UUID uuid) {
        T object = this.find(uuid);

        if (object == null)
            return Optional.empty();
        return Optional.of(object);
    }

    @Nullable
    public T find(String id) {
        return this.find(UUID.fromString(id));
    }

    public void replace(T object) {
        this.cache.replace(object.uuid(), object);
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return this.cache.values().iterator();
    }
}
