package top.jonakls.bomberman.plugin.command;

import dev.triumphteam.cmd.core.BaseCommand;
import dev.triumphteam.cmd.core.annotation.Command;
import dev.triumphteam.cmd.core.annotation.Default;
import org.bukkit.entity.Player;

@Command(
        value = "bomberman",
        alias = {"bm", "bomber"}
)
public class MainCommand extends BaseCommand {

    @Default
    public void onDefault(Player sender) {
        sender.sendMessage("Hello, world!");
    }
}
