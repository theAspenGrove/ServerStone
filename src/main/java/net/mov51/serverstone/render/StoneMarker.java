package net.mov51.serverstone.render;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import static net.mov51.serverstone.ServerStone.configHelper;
import static net.mov51.serverstone.ServerStone.plugin;
import static net.mov51.serverstone.render.MarkerRenderer.renderMarker;

public class StoneMarker {
    private BukkitTask markerTask = null;
    public StoneMarker(){
        start();
    }
    public void start(){
        if (markerTask != null) {
            markerTask.cancel();
            markerTask = null;
        }
        int updateRate = 1;
        markerTask = new BukkitRunnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    renderMarker(p);
                }
            }
        }.runTaskTimer(plugin, updateRate, configHelper.getParticleInterval());
    }
}
