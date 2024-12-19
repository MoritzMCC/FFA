package de.MoritzMCC.ffaPlayer;

import org.bukkit.Bukkit;

import java.io.ObjectInputFilter;
import java.util.UUID;

public class FFAPlayer {

    protected final UUID uuid;
    protected final String name;
    protected int kills;
    protected String status;
    private

    public FFAPlayer(UUID uuid) {
        this.uuid = uuid;
        this.name = Bukkit.getPlayer(uuid).getName();
        status = "KitSelection";
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
    public String getStatus() {
        return status;
    }

}
