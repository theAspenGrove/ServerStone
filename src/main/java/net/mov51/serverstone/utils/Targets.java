package net.mov51.serverstone.utils;

import net.mov51.serverstone.ServerStone;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Powerable;

import java.util.ArrayList;
import java.util.List;

import static net.mov51.serverstone.ServerStone.configHelper;
import static net.mov51.serverstone.utils.Announce.announce;

public class Targets {
    //list of block targets
    private List<Location> targetedBlocks = new ArrayList<>();

    public Targets(){
        //constructor
        this.load();
        //save targets every 5 minutes
        ServerStone.plugin.getServer().getScheduler().scheduleSyncRepeatingTask(ServerStone.plugin, this::save, 0L, configHelper.getSaveInterval());
    }

    public void save(){
        //save the list of targets to the config
        configHelper.saveTargets(targetedBlocks);
    }

    public void load(){
        //load the list of targets from the config
        List<?> list = configHelper.getTargets();
        if(list != null){
            for(Object o : list){
                if(o instanceof Location){
                    this.targetedBlocks.add((Location) o);
                }
            }
        }
    }

    public void add(Location location){
        this.targetedBlocks.add(location);
    }

    public void remove(Location location){
        this.targetedBlocks.remove(location);
    }

    public void powerAll(boolean checkForLoaded){
        for(Location blockL : this.targetedBlocks){
            setPowerState(blockL,"true",checkForLoaded);
        }
    }

    public void dePowerAll(boolean checkForLoaded){
        for(Location blockL : this.targetedBlocks){
            setPowerState(blockL,"false",checkForLoaded);
        }
    }

    public void toggleAll(boolean checkForLoaded){
        for(Location blockL : this.targetedBlocks){
            setPowerState(blockL,"toggle",checkForLoaded);
        }
    }

    public boolean contains(Location location){
        return this.targetedBlocks.contains(location);
    }

    private void setPowerState(Location location, String state, boolean checkForLoaded){
        //only set the power state if the block is loaded
        if(checkForLoaded){
            if(!location.isWorldLoaded()){
                return;
            }
        }
        if(location.getBlock().getType() == Material.LEVER){
            BlockData blockData = location.getBlock().getBlockData();
            if(blockData instanceof Powerable){
                Powerable powerable = (Powerable) blockData;
                if(state.equals("toggle")){
                    powerable.setPowered(!powerable.isPowered());
                }else{
                    powerable.setPowered(Boolean.parseBoolean(state));
                }
                location.getBlock().setBlockData(powerable);
                announce(location, location.getBlock().getType());
            }
        }else{
            this.remove(location);
        }
    }
}