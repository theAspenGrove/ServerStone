package net.mov51.serverstone;

import net.mov51.serverstone.commands.ServerStoneCommand;
import net.mov51.serverstone.utils.ConfigHelper;
import net.mov51.serverstone.utils.Targets;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ServerStone extends JavaPlugin {
    public static Targets targets;
    public static Plugin plugin = null;

    public static ConfigHelper configHelper = null;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        //create config
        configHelper = new ConfigHelper(this.getConfig());
        //register commands
        Objects.requireNonNull(this.getCommand("serverstone")).setExecutor(new ServerStoneCommand());
        //register events
        getServer().getPluginManager().registerEvents(new net.mov51.serverstone.events.ClickEvent(), this);
        getServer().getPluginManager().registerEvents(new net.mov51.serverstone.events.BreakEvent(), this);
        //create targets
        targets = new Targets();
        //yell
        getLogger().info("Your server has been STONED!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        targets.save();
    }
}
