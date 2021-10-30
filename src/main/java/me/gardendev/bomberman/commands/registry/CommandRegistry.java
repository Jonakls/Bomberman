package me.gardendev.bomberman.commands.registry;

import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.part.PartInjector;
import me.fixeddev.commandflow.annotated.part.defaults.DefaultsModule;
import me.fixeddev.commandflow.bukkit.BukkitCommandManager;
import me.fixeddev.commandflow.bukkit.factory.BukkitModule;
import me.gardendev.bomberman.Bomberman;
import me.gardendev.bomberman.commands.MainCommand;

public class CommandRegistry {
    private final CommandManager commandManager;
    private final AnnotatedCommandTreeBuilder treeBuilder;

    private final Bomberman plugin;

    public CommandRegistry(Bomberman plugin) {
        this.plugin = plugin;
        PartInjector injector = PartInjector.create();
        injector.install(new DefaultsModule());
        injector.install(new BukkitModule());

        this.commandManager = new BukkitCommandManager(plugin.getName());
        this.treeBuilder = AnnotatedCommandTreeBuilder.create(injector);
    }

    public void register() {
        this.commandManager.registerCommands(treeBuilder.fromClass(new MainCommand()));
    }

    public void unregister() {
        this.commandManager.unregisterAll();
    }
}
