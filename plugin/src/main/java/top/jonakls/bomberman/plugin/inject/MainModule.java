package top.jonakls.bomberman.plugin.inject;

import org.bukkit.plugin.Plugin;
import team.unnamed.inject.AbstractModule;

public class MainModule extends AbstractModule {

    private final Plugin plugin;

    public MainModule(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {
        this.bind(Plugin.class).toInstance(this.plugin);
    }
}
