package net.mov51.serverstone.utils;

import net.mov51.serverstone.ServerStone;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Objects;

public class ConfigHelper {

    private FileConfiguration config = null;

    public ConfigHelper(FileConfiguration fConfig){
        this.config = fConfig;
        config.addDefault("saveInterval", 6000);
        config.addDefault("upgradeMaterial", "NETHER_STAR");
        config.addDefault("particleInterval", 10);
        config.addDefault("particle", "COMPOSTER");
        config.options().copyDefaults(true);
        ServerStone.plugin.saveConfig();

    }
    public int getSaveInterval(){
        return this.config.getInt("saveInterval");
    }
    public ItemStack getUpgradeItem(){
        return new ItemStack(Material.valueOf(Objects.requireNonNull(this.config.getString("upgradeMaterial")).toUpperCase()));
    }
    public Material getUpgradeMaterial(){
        return Material.valueOf(this.config.getString("upgradeMaterial"));
    }
    public void saveTargets(List<Location> targetedBlocks){
        this.config.set("targets", null);
        this.config.set("targets", targetedBlocks);
        ServerStone.plugin.saveConfig();
        config = ServerStone.plugin.getConfig();
    }
    public List<?> getTargets(){
        return this.config.getList("targets", null);
    }
    public int getParticleInterval(){
        return this.config.getInt("particleInterval");
    }
    public Particle getParticle(){
        return Particle.valueOf(this.config.getString("particle"));
    }

}
