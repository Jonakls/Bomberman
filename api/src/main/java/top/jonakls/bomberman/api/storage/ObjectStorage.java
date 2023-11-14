package top.jonakls.bomberman.api.storage;

import top.jonakls.bomberman.api.model.Model;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface ObjectStorage<T extends Model> {

    T findSync(String id);

    CompletableFuture<T> find(String id);

    Optional<T> optionalFindSync(String id);

    CompletableFuture<Optional<T>> optionalFind(String id);

    void saveSync(T object);

    CompletableFuture<T> save(T object);

    void deleteSync(String id);

    CompletableFuture<T> delete(String id);

    void updateSync(T object);

    CompletableFuture<T> update(T object);
}
