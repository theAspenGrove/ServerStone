package net.mov51.serverstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import static net.mov51.serverstone.ServerStone.*;
import static net.mov51.serverstone.utils.Announce.sendMessage;

public class ServerStoneCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length == 0){
            sendMessage(sender,"§cUsage: /serverstone <toggle | power | depower | save> [loaded | all]");
            return true;
        }
        switch (args[0]) {
            case "toggle":
                if(args.length == 1 || (args.length == 2 && args[1].equals("loaded"))){
                    targets.toggleAll(true);
                    sendMessage(sender, "Toggled all loaded Serverstone targets");
                    return true;
                }else if (args.length == 2 && args[1].equals("all")) {
                    targets.toggleAll(false);
                    sendMessage(sender, "Toggled all Serverstone targets");
                    return true;
                }else{
                    sendMessage(sender, "Usage: /serverstone toggle [loaded | all]");
                    return true;
                }
            case "power":
                if(args.length == 1|| (args.length == 2 && args[1].equals("loaded"))){
                    targets.powerAll(true);
                    sendMessage(sender, "Powered all loaded ServerStone targets");
                    return true;
                }else if (args.length == 2 && args[1].equals("all")) {
                    targets.powerAll(false);
                    sendMessage(sender, "Powered all Serverstone targets");
                    return true;
                }else{
                    sendMessage(sender, "Usage: /serverstone power [loaded | all]");
                    return true;
                }
            case "depower":
                if(args.length == 1 || (args.length == 2 && args[1].equals("loaded"))){
                    targets.dePowerAll(true);
                    sendMessage(sender, "Depowered all loaded ServerStone targets");
                    return true;
                }else if (args.length == 2 && args[1].equals("all")) {
                    targets.dePowerAll(false);
                    sendMessage(sender, "Depowered all ServerStone targets");
                    return true;
                }else{
                    sendMessage(sender, "Usage: /serverstone depower [loaded | all]");
                    return true;
                }
            case "save":
                targets.save();
                sendMessage(sender, "Saved ServerStone target list");
                return true;
            default:
                sendMessage(sender, "Invalid sub-command");
                return false;
        }
    }
}
