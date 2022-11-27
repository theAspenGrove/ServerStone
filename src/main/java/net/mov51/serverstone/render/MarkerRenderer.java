package net.mov51.serverstone.render;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import static net.mov51.serverstone.ServerStone.configHelper;
import static net.mov51.serverstone.ServerStone.targets;

public class MarkerRenderer {
    public static void renderMarker(Player player){
        Location loc = player.getLocation().clone();
        World world = loc.getWorld();
        int px = loc.getBlockX(), py = loc.getBlockY(), pz = loc.getBlockZ();

        int radA = 10;
        int radH = 10;

        for (int z = -radA; z <= radA; z++) {

            for (int x = -radA; x <= radA; x++) {

                for (int y = -radH; y <= radH; y++) {
                    if (Math.sqrt((x * x) + (y * y) + (z * z)) > radA) continue;
                    assert world != null;
                    Block block = world.getBlockAt(px + x, py + y, pz + z);

                    if(targets.contains(block.getLocation())){
                        summonMarker(player,block);
                    }
                }
            }
        }
    }
    private static void summonMarker(Player player, Block block){
        player.spawnParticle(configHelper.getParticle(),block.getLocation().toCenterLocation(),1);
    }
}
