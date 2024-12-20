package de.MoritzMCC.Listener;


import de.MoritzMCC.arena.Mapmanager;
import de.MoritzMCC.fFAPit.Main;
import de.MoritzMCC.ffaPlayer.FFAPlayer;
import de.MoritzMCC.ffaPlayer.FFAPlayerList;
import de.MoritzMCC.ffaPlayer.Status;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;

import java.util.Arrays;


public class DeathListener implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        FFAPlayer ffaPlayer = FFAPlayerList.getPlayer(player.getUniqueId());
        event.setDeathMessage(null);
       if(ffaPlayer== null) return;
       if(System.currentTimeMillis() - ffaPlayer.getEnemyHit().getValue() > 1000*30)return;

       FFAPlayer attacker = FFAPlayerList.getPlayer(ffaPlayer.getEnemyHit().getKey());
       attacker.increaseKills();


    }
    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        Mapmanager mapmanager = Main.getMapmanager();
        event.setRespawnLocation(mapmanager.kitSelectionSpawn());
        FFAPlayer ffaPlayer = FFAPlayerList.getPlayer(player.getUniqueId());
        if(ffaPlayer == null) return;
        ffaPlayer.setStatus(Status.KitSelection);

        player.setMaxHealth(20);
        player.setHealth(player.getMaxHealth());
        player.setFoodLevel(20);
        player.setLevel(0);
        player.setFireTicks(0);
        player.setGliding(false);
        player.setGlowing(false);
        player.setTotalExperience(0);
        player.setGameMode(GameMode.ADVENTURE);
        player.setAllowFlight(true);
        player.setFlying(true);
        player.getActivePotionEffects().stream().map(PotionEffect::getType).forEach(player::removePotionEffect);

        mapmanager.setKitselectionEquipment(player);

    }
}
