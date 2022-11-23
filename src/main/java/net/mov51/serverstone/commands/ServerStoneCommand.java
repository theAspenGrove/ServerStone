package net.mov51.serverstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import static net.mov51.serverstone.ServerStone.targets;

public class ServerStoneCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        switch (args[0]) {
            case "add":
                new AddTargetCommand().onCommand(sender, command, label, args);
                return true;
            case "remove":
                new RemoveTargetCommand().onCommand(sender, command, label, args);
                return true;
            case "power":
                targets.powerAll();
                return true;
            case "depower":
                targets.dePowerAll();
                return true;
            default:
                sender.sendMessage("Invalid sub-command");
                break;
        }
        return false;
    }
}
