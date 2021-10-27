package me.gardendev.bomberman.commands;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.annotated.annotation.SubCommandClasses;
import me.gardendev.bomberman.commands.game.JoinCommand;
import me.gardendev.bomberman.commands.setup.SetupCommand;

@Command(
        names = {"bomberman"},
        desc = "Si",
        permission = "bomberman.command",
        permissionMessage = "No permissions"
)
@SubCommandClasses({
        JoinCommand.class,
        SetupCommand.class
})
@SuppressWarnings("all")
public class MainCommand implements CommandClass {

    @Command(names = {""})
    public void reload() {

    }

}
