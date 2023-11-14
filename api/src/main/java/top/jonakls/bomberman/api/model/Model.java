package top.jonakls.bomberman.api.model;

import java.util.UUID;

public interface Model {

    String id();

    default UUID uuid() {
        return UUID.fromString(id());
    }

}
