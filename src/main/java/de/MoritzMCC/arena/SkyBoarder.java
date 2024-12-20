package de.MoritzMCC.arena;

import de.MoritzMCC.fFAPit.Main;
import de.MoritzMCC.ffaPlayer.FFAPlayer;
import de.MoritzMCC.ffaPlayer.FFAPlayerList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SkyBoarder extends BukkitRunnable {
    private final int damage;
    private final int heigh;

    public SkyBoarder(int damage, int height) {
        this.damage = damage;
        this.heigh = height;
    }
   @Override
    public void run(){
       for (FFAPlayer ffaPlayer: FFAPlayerList.getPlayerList()){
           Player player = Bukkit.getPlayer(ffaPlayer.getUuid());
         if(player ==null)return;
         if(player.getLocation().getY() >= heigh )player.damage(damage);
       }
   }
}
