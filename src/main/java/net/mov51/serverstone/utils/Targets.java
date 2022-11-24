package net.mov51.serverstone.utils;

import net.mov51.serverstone.ServerStone;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Powerable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Targets {
    //list of block targets
    private List<Location> targetedBlocks = new ArrayList<>();

    public Targets(){
        //constructor
    }

    public void add(Location location){
        this.targetedBlocks.add(location);
        System.out.println("Added target: " + location);
    }

    public void remove(Location location){
        this.targetedBlocks.remove(location);
        System.out.println("Removed target: " + location);
    }

    public void clear(){
        this.targetedBlocks.clear();
        System.out.println("Targets cleared");
    }

    public void powerAll(){
        for(Location blockL : this.targetedBlocks){
            setPowerState(blockL,true);
        }
    }

    public void dePowerAll(){
        for(Location blockL : this.targetedBlocks){
            setPowerState(blockL,false);
        }
    }

    public void toggleAll(){
        for(Location blockL : this.targetedBlocks){
            togglePowerState(blockL);
        }
    }

    public boolean contains(Location location){
        return this.targetedBlocks.contains(location);
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

    private void togglePowerState(Location location){
        if(location.getBlock().getType() == Material.LEVER){
            BlockData blockData = location.getBlock().getBlockData();
            if(blockData instanceof Powerable){
                Powerable powerable = (Powerable) blockData;
                powerable.setPowered(!powerable.isPowered());
                location.getBlock().setBlockData(powerable);
            }
        }else{
            System.out.println("Target is not a lever: " + location);
            this.remove(location);
        }
    }
}