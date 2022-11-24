package net.mov51.serverstone.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static net.mov51.serverstone.ServerStone.targets;

public class ClickEvent implements Listener {
    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getClickedBlock() == null) {
                return;
            }
            if(event.getItem() == null){
                return;
            }
            Block block = event.getClickedBlock();
            ItemStack item = event.getItem();
            if (block.getType() == Material.LEVER) {
                //remove target
                if(targets.contains(block.getLocation())){
                    block.getLocation().getWorld().dropItemNaturally(block.getLocation(),new ItemStack(Material.NETHER_STAR));
                    targets.remove(block.getLocation());
                    event.setCancelled(true);
                    System.out.println("Removed target: " + block.getLocation());
                }else {
                    if (item.getType() == Material.NETHER_STAR) {
                        //add target
                        targets.add(block.getLocation());
                        item.setAmount(item.getAmount() - 1);
                        if(event.getHand() != null)
                            event.getPlayer().getInventory().setItem(event.getHand(), item);
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
