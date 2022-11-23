package net.mov51.serverstone;

import net.mov51.serverstone.commands.ServerStoneCommand;
import net.mov51.serverstone.utils.Targets;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ServerStone extends JavaPlugin {
    public static Targets targets = new Targets();

    @Override
    public void onEnable() {
        // Plugin startup logic

        getLogger().info("Your server has been STONED!");
        Objects.requireNonNull(this.getCommand("serverstone")).setExecutor(new ServerStoneCommand());
        //register events
        getServer().getPluginManager().registerEvents(new net.mov51.serverstone.events.ClickEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
