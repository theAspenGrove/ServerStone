package net.mov51.serverstone;

import org.bukkit.plugin.java.JavaPlugin;

public final class ServerStone extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Your server has been STONED!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
