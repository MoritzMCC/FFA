package de.MoritzMCC.arena;

import de.MoritzMCC.utils.ItemBuilder;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class Mapmanager {

    World world;
    int mapsize;
    private final Location center;


    public Mapmanager(World world, int mapsize) {

        this.world = world;
        this.mapsize = mapsize;
        center = new Location(world, 0, 0, 0);
        world.getWorldBorder().setCenter(center);
        world.getWorldBorder().setSize(mapsize);
        world.getWorldBorder().setWarningDistance(5);
        world.setDifficulty(Difficulty.EASY);
        world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        world.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        world.setGameRule(GameRule.DO_MOB_SPAWNING, false);
        world.setGameRule(GameRule.DO_TILE_DROPS, false);
        world.setTime(1000);
        world.setWeatherDuration(0);
        world.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);

        createKitSelectionArea();
    }

    public Location getRandomSpawnLocation() {
        Random rand = new Random();
        int x = rand.nextInt(mapsize);
        int z = rand.nextInt(mapsize);
        int y = world.getHighestBlockYAt(x, z);
         return new Location(world,x,y,z );
    }

    public void setEquipment(Player player){
        Inventory inventory = player.getInventory();
        inventory.setItem(0, new ItemBuilder(Material.STONE_SWORD).setUnbreakable(true).build());
        inventory.setItem(13, new ItemStack(Material.BOWL, 32));
        inventory.setItem(14, new ItemStack(Material.RED_MUSHROOM, 32));
        inventory.setItem(15, new ItemStack(Material.BROWN_MUSHROOM, 32));
        for(int i = 0; i < inventory.getSize(); i++){
            if(inventory.getItem(i) != null)continue;
            inventory.setItem(i, new ItemStack(Material.MUSHROOM_STEW));

        }

    }

    public void createKitSelectionArea(){
        int size = 51;
        int wallHeight = 10;
        int halfSize = size / 2;

        for (int x = -halfSize; x <= halfSize; x++) {
            for (int z = -halfSize; z <= halfSize; z++) {
                for (int y = 0; y < wallHeight; y++) {
                    Block block = world.getBlockAt(center.getBlockX() + x, center.getBlockY() + y, center.getBlockZ() + z);

                    if (x == -halfSize || x == halfSize || z == -halfSize || z == halfSize) {
                        block.setType(Material.GLASS);
                    } else {
                        block.setType(Material.AIR);
                    }
                }
            }
        }
    }

    public void setKitselectionEquipment(Player player){
        Inventory inventory = player.getInventory();
        inventory.setItem(0, new ItemBuilder(Material.CHEST).withName(ChatColor.GOLD + "Kit Selection").build());
        inventory.setItem(1, new ItemBuilder(Material.MAP).withName(ChatColor.AQUA + "Teleport to arena").build());


    }
    public Location kitSelectionSpawn(){
        return center.add(0, 180, 0);
    }

}
