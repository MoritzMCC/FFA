package de.MoritzMCC.ffaPlayer;

import org.bukkit.Bukkit;

import java.io.ObjectInputFilter;
import java.util.AbstractMap;
import java.util.Map;
import java.util.UUID;

public class FFAPlayer {

    protected final UUID uuid;
    protected final String name;
    protected int kills;
    protected Status status;
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
}
