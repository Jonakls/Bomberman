package top.jonakls.bomberman.plugin.inject.command;

import dev.triumphteam.cmd.core.BaseCommand;
import team.unnamed.inject.AbstractModule;
import top.jonakls.bomberman.plugin.command.MainCommand;

public class CommandModule extends AbstractModule {

    @Override
    protected void configure() {
        this.multibind(BaseCommand.class).asSet()
                .to(MainCommand.class)
                .singleton();
    }
}
