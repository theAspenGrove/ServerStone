package net.mov51.serverstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import static net.mov51.serverstone.ServerStone.targets;

public class ServerStoneCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length == 0){
            sender.sendMessage("§cUsage: /serverstone <toggle | power | depower | save> [loaded | all]");
            return true;
        }
        switch (args[0]) {
            case "toggle":
                if(args.length == 1 || (args.length == 2 && args[1].equals("loaded"))){
                    targets.toggleAll(true);
                    return true;
                }else if (args.length == 2 && args[1].equals("all")) {
                    targets.toggleAll(false);
                    return true;
                }
                return false;
            case "power":
                if(args.length == 1|| (args.length == 2 && args[1].equals("loaded"))){
                    targets.powerAll(true);
                    return true;
                }else if (args.length == 2 && args[1].equals("all")) {
                    targets.powerAll(false);
                    return true;
                }
                return false;
            case "depower":
                if(args.length == 1 || (args.length == 2 && args[1].equals("loaded"))){
                    targets.dePowerAll(true);
                    return true;
                }else if (args.length == 2 && args[1].equals("all")) {
                    targets.dePowerAll(false);
                    return true;
                }
            case "save":
                targets.save();
                return true;
            default:
                sender.sendMessage("Invalid sub-command");
                return false;
        }
    }
}
