package me.jonakls.bomberman.files;

import me.jonakls.bomberman.Bomberman;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class YamlFile extends YamlConfiguration {

    private File file;
    private String fileName;
    private Bomberman plugin;

    private YamlFile(Bomberman plugin, String fileName, String fileExtension, File folder) {
        this.plugin = plugin;
        this.fileName = fileName + (fileName.endsWith(fileExtension) ? " " : fileExtension);
        this.file = new File(folder, fileName);
        this.createFile();
    }

    private YamlFile(Bomberman plugin, String fileName, String fileExtension) {
        this(plugin, fileName, fileExtension, plugin.getDataFolder());
    }

    public YamlFile(Bomberman plugin, String fileName ) {
        this(plugin, fileName, ".yml");
    }


    private void createFile() {

    }
}
