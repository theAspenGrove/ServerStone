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
                    sender.sendMessage("§aToggled all loaded Serverstone targets");
                    return true;
                }else if (args.length == 2 && args[1].equals("all")) {
                    targets.toggleAll(false);
                    sender.sendMessage("§aToggled all Serverstone targets");
                    return true;
                }else{
                    sender.sendMessage("§cUsage: /serverstone toggle [loaded | all]");
                    return true;
                }
            case "power":
                if(args.length == 1|| (args.length == 2 && args[1].equals("loaded"))){
                    targets.powerAll(true);
                    sender.sendMessage("§aPowered all loaded ServerStone targets");
                    return true;
                }else if (args.length == 2 && args[1].equals("all")) {
                    targets.powerAll(false);
                    sender.sendMessage("§aPowered all Serverstone targets");
                    return true;
                }else{
                    sender.sendMessage("§cUsage: /serverstone power [loaded | all]");
                    return true;
                }
            case "depower":
                if(args.length == 1 || (args.length == 2 && args[1].equals("loaded"))){
                    targets.dePowerAll(true);
                    sender.sendMessage("§aDepowered all loaded ServerStone targets");
                    return true;
                }else if (args.length == 2 && args[1].equals("all")) {
                    targets.dePowerAll(false);
                    sender.sendMessage("§aDepowered all ServerStone targets");
                    return true;
                }else{
                    sender.sendMessage("§cUsage: /serverstone depower [loaded | all]");
                    return true;
                }
            case "save":
                targets.save();
                sender.sendMessage("§aSaved ServerStone target list");
                return true;
            default:
                sender.sendMessage("Invalid sub-command");
                return false;
        }
    }
}
