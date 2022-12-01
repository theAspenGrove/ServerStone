package net.mov51.serverstone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ServerStoneTabComplete implements TabCompleter {
    List<String> commands = Arrays.asList("toggle", "power", "depower", "save");
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return commands;
        } else if (args.length == 2 && commands.contains(args[0])) {
            return Arrays.asList("loaded", "all");
        }
        return null;
    }
}
