package net.mov51.serverstone.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Powerable;

import java.util.HashSet;

public class Targets {
    //list of block targets
    private static HashSet<Location> targets = new HashSet<>();

    public Targets(){
        //constructor
    }

    public void add(Location location){
        targets.add(location);
        System.out.println("Added target: " + location);
    }
    public void remove(Location location){
        targets.remove(location);
        System.out.println("Removed target: " + location);
    }
    public void clear(){
        targets.clear();
        System.out.println("Targets cleared");
    }
    public void powerAll(){
        for(Location blockL : targets){
            setPowerState(blockL,true);
        }
    }

    public void dePowerAll(){
        for(Location blockL : targets){
            setPowerState(blockL,false);
        }
    }
    public boolean contains(Location location){
        return targets.contains(location);
    }

    private void setPowerState(Location location, boolean state){
        if(location.getBlock().getType() == Material.LEVER){
            BlockData blockData = location.getBlock().getBlockData();
            if(blockData instanceof Powerable){
                Powerable powerable = (Powerable) blockData;
                powerable.setPowered(state);
                location.getBlock().setBlockData(powerable);
            }
        }else{
            System.out.println("Target is not a lever: " + location);
            this.remove(location);
        }
    }
}
