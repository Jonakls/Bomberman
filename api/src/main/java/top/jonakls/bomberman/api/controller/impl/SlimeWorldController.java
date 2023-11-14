package top.jonakls.bomberman.api.controller.impl;

import com.grinderwolf.swm.api.SlimePlugin;
import com.grinderwolf.swm.api.exceptions.*;
import com.grinderwolf.swm.api.loaders.SlimeLoader;
import com.grinderwolf.swm.api.world.SlimeWorld;
import com.grinderwolf.swm.api.world.properties.SlimePropertyMap;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import top.jonakls.bomberman.api.controller.WorldController;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public class SlimeWorldController implements WorldController {

    private final Plugin plugin;
    private final SlimePlugin slimePlugin;
    private final String loader;
    private final SlimePropertyMap propertyMap;

    public SlimeWorldController(Plugin plugin, String loader, SlimePropertyMap propertyMap) {
        this.plugin = plugin;
        this.slimePlugin = (SlimePlugin) plugin.getServer().getPluginManager().getPlugin("SlimeWorldManager");
        this.loader = loader;
        this.propertyMap = propertyMap;
    }

    @Override
    public World loadWorld(String worldName) throws CorruptedWorldException, NewerFormatException, WorldInUseException, UnknownWorldException, IOException {
        SlimeLoader slimeLoader = this.slimePlugin.getLoader(this.loader);
        SlimeWorld slimeWorld = this.slimePlugin.loadWorld(slimeLoader, worldName, false, propertyMap);

        this.slimePlugin.generateWorld(slimeWorld);
        return this.plugin.getServer().getWorld(slimeWorld.getName());
    }

    @Override
    public World loadTempWorld(String worldName) throws CorruptedWorldException, NewerFormatException, WorldInUseException, UnknownWorldException, IOException {
        SlimeLoader slimeLoader = this.slimePlugin.getLoader(this.loader);
        SlimeWorld slimeWorld = this.slimePlugin.loadWorld(slimeLoader, worldName, false, propertyMap);
        SlimeWorld tempWorld = slimeWorld.clone("temp-" + UUID.randomUUID().toString());

        this.slimePlugin.generateWorld(tempWorld);
        return this.plugin.getServer().getWorld(tempWorld.getName());
    }

    @Override
    public void unloadWorld(String worldName, boolean save) {
        Bukkit.unloadWorld(worldName, save);
    }

    @Override
    public Optional<SlimeWorld> getSlimeWorld(String worldName, boolean readOnly) {
        SlimeLoader slimeLoader = slimePlugin.getLoader(this.loader);
        try {
            if (!slimeLoader.worldExists(worldName)) {
                return Optional.empty();
            }

            return Optional.of(slimePlugin.loadWorld(slimeLoader, worldName, readOnly, this.propertyMap));
        } catch (Exception ex) {
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public SlimeWorld createWorld(String worldName) {
        SlimeLoader slimeLoader = slimePlugin.getLoader(this.loader);

        try {
            return slimePlugin.createEmptyWorld(slimeLoader, worldName, false, this.propertyMap);
        } catch (IOException | WorldAlreadyExistsException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteWorld(String worldName) throws IOException, UnknownWorldException {
        SlimeLoader slimeLoader = this.slimePlugin.getLoader(this.loader);
        slimeLoader.deleteWorld(worldName);
    }
}
