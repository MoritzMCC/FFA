package de.MoritzMCC.kits;

import de.MoritzMCC.ffaPlayer.FFAPlayer;
import de.MoritzMCC.ffaPlayer.FFAPlayerList;
import de.hglabor.plugins.kitapi.kit.AbstractKit;
import de.hglabor.plugins.kitapi.player.KitPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class NinjaKit extends AbstractKit {

    private final long lastHitExpiration = 15L;
    private final double radius = 30D;
    private float cooldown = 4f;

    public NinjaKit(String name, Material material) {
        super(name, material);
    }


    @Override
    public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        FFAPlayer ffaPlayer = FFAPlayerList.getPlayer(player.getUniqueId());
        if(ffaPlayer == null)return;
        AbstractKit kit = ffaPlayer.getKit();
        if (kit != this)return;
        if (event.isSneaking() && ffaPlayer.getEnemyHit().getKey() != null) {
            if (ffaPlayer.getLastKitUse() + 1000* cooldown>System.currentTimeMillis() && ffaPlayer.getEnemyHit().getValue() + 1000* lastHitExpiration < System.currentTimeMillis()) {
                Player target = Bukkit.getPlayer(ffaPlayer.getEnemyHit().getKey());
                if (target == null) return;
                if (distanceBetweenEntities(player, target) < radius * radius) {
                    player.teleport(calculateNinjaBehind(target));
                    ffaPlayer.setLastKitUse(System.currentTimeMillis());
                    return;
                }
                player.sendMessage("You are to far away");
                return;
            }
            player.sendMessage("You are still on Cooldown + ");
        }

    }
    private Location calculateNinjaBehind(Entity entity) {
        float nang = entity.getLocation().getYaw() + 90;
        if (nang < 0) nang += 360;
        double nX = Math.cos(Math.toRadians(nang));
        double nZ = Math.sin(Math.toRadians(nang));
        return entity.getLocation().clone().subtract(nX, 0, nZ);
    }

    private double distanceBetweenEntities(Player player, Entity entity) {
        Location ninjaLocation = player.getLocation().clone();
        Location entityLocation = entity.getLocation().clone();
        ninjaLocation.setY(0);
        entityLocation.setY(0);
        return ninjaLocation.distanceSquared(entityLocation);
    }


}


