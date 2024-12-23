package de.MoritzMCC.ffaPlayer;

import de.hglabor.plugins.kitapi.kit.AbstractKit;
import org.bukkit.Bukkit;

import java.util.AbstractMap;
import java.util.Map;
import java.util.UUID;

public class FFAPlayer {

    private AbstractKit kit;
    protected final UUID uuid;
    protected final String name;
    protected int kills;
    protected Status status;
    private long lastKitUse;
    private Map.Entry<UUID, Long> enemyHit= new AbstractMap.SimpleEntry<>(null, 0L);

    public FFAPlayer(UUID uuid) {
        this.uuid = uuid;
        this.name = Bukkit.getPlayer(uuid).getName();
        status = Status.KitSelection;

    }

    public int getKills() {
        return kills;
    }

    public UUID getUuid() {
        return uuid;
    }
    public String getName() {
        return name;
    }
    public Status getStatus() {
        return status;
    }

    public Map.Entry<UUID, Long> getEnemyHit() {
        return enemyHit;
    }

    public void setEnemyHit(UUID uuid, Long currentTimeMillie) {
        enemyHit = new AbstractMap.SimpleEntry<>(uuid,currentTimeMillie);

    }
    public void increaseKills() {
        kills++;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public AbstractKit getKit() {
        return kit;
    }

    public void setKit(AbstractKit kit) {
        this.kit = kit;
    }

    public long getLastKitUse() {
        return lastKitUse;
    }

    public void setLastKitUse(long lastKitUse) {
        this.lastKitUse = lastKitUse;
    }
}
