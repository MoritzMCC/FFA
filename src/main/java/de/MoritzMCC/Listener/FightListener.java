package de.MoritzMCC.Listener;

import de.MoritzMCC.ffaPlayer.FFAPlayerList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.UUID;

public class FightListener implements Listener {

    @EventHandler
    public void onFight(EntityDamageByEntityEvent event) {
     if (!(event.getEntity() instanceof Player)) return;
     if (!(event.getDamager() instanceof Player)) return;
     Player attacker = (Player) event.getDamager();
     Player victim = (Player) event.getEntity();
     UUID attackerUUID = attacker.getUniqueId();
     UUID victimUUID = victim.getUniqueId();
     FFAPlayerList.getPlayers().get(victimUUID).setEnemyHit(attackerUUID, System.currentTimeMillis());
    }
}
