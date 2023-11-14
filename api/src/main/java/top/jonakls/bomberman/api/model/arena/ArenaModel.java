package top.jonakls.bomberman.api.model.arena;

import top.jonakls.bomberman.api.model.Model;

public class ArenaModel implements Model {

    private final String id;
    private String name;
    private String description;
    private String map;

    public ArenaModel(String id, String name, String description, String map) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.map = map;
    }

    @Override
    public String id() {
        return this.id;
    }
}
