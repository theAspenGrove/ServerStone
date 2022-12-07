package net.mov51.serverstone.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.mov51.serverstone.ServerStone.*;

public class Announce {
    static int range;
    public static void announce(Location location, Material material){
        range = configHelper.getAnnouncementRange();
        //announce a message to the server at a location
        location.getWorld().getNearbyEntities(location, range, range, range).forEach(entity -> {
            if(entity instanceof Player){
                chatHelper.sendChat((Player) entity,"ServerStone " + material.name() + " was activated at " + location.getBlockX() + ", " + location.getBlockY() + ", " + location.getBlockZ());
            }
        });
    }
    public static void sendMessage(CommandSender sender, String message){
        if(sender instanceof Player) {
            chatHelper.sendChat((Player) sender, message);
        }else{
            plugin.getLogger().info(message);
        }
    }
}
