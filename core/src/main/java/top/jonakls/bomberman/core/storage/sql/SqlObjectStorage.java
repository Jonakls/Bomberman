package top.jonakls.bomberman.core.storage.sql;

import top.jonakls.bomberman.api.model.Model;
import top.jonakls.bomberman.api.storage.ObjectStorage;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class SqlObjectStorage<T extends Model> implements ObjectStorage<T> {

    

    @Override
    public T findSync(String id) {
        return null;
    }

    @Override
    public CompletableFuture<T> find(String id) {
        return null;
    }

    @Override
    public Optional<T> optionalFindSync(String id) {
        return Optional.empty();
    }

    @Override
    public CompletableFuture<Optional<T>> optionalFind(String id) {
        return null;
    }

    @Override
    public void saveSync(T object) {

    }

    @Override
    public CompletableFuture<T> save(T object) {
        return null;
    }

    @Override
    public void deleteSync(String id) {

    }

    @Override
    public CompletableFuture<T> delete(String id) {
        return null;
    }

    @Override
    public void updateSync(T object) {

    }

    @Override
    public CompletableFuture<T> update(T object) {
        return null;
    }
}
