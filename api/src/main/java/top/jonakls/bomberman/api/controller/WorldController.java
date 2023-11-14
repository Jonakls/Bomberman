package top.jonakls.bomberman.api.controller;

import com.grinderwolf.swm.api.exceptions.CorruptedWorldException;
import com.grinderwolf.swm.api.exceptions.NewerFormatException;
import com.grinderwolf.swm.api.exceptions.UnknownWorldException;
import com.grinderwolf.swm.api.exceptions.WorldInUseException;
import com.grinderwolf.swm.api.world.SlimeWorld;
import org.bukkit.World;

import java.io.IOException;
import java.util.Optional;

public interface WorldController {

    World loadWorld(String worldName) throws CorruptedWorldException, NewerFormatException, WorldInUseException, UnknownWorldException, IOException;

    World loadTempWorld(String worldName) throws CorruptedWorldException, NewerFormatException, WorldInUseException, UnknownWorldException, IOException;

    void unloadWorld(String worldName, boolean save);

    default void unloadWorld(World world) {
        unloadWorld(world.getName(), false);
    }

    Optional<SlimeWorld> getSlimeWorld(String worldName, boolean readOnly);

    SlimeWorld createWorld(String worldName);

    void deleteWorld(String worldName) throws IOException, UnknownWorldException;

}
