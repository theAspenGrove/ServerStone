package net.mov51.serverstone;

import net.mov51.serverstone.commands.ServerStoneCommand;
import net.mov51.serverstone.utils.Targets;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ServerStone extends JavaPlugin {
    public static Targets targets = new Targets();
    public static Plugin plugin = null;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getLogger().info("Your server has been STONED!");
        Objects.requireNonNull(this.getCommand("serverstone")).setExecutor(new ServerStoneCommand());
        //register events
        getServer().getPluginManager().registerEvents(new net.mov51.serverstone.events.ClickEvent(), this);
        getServer().getPluginManager().registerEvents(new net.mov51.serverstone.events.BreakEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
