package de.MoritzMCC.ffaPlayer;

import java.util.*;

public class FFAPlayerList {

    private static final FFAPlayerList instance = new FFAPlayerList();
    private static final Map<UUID, FFAPlayer> playerList = new HashMap();

    public static FFAPlayer getPlayer(UUID uuid) {
        return playerList.get(uuid);
    }
    public void addPlayer(FFAPlayer player) {
        playerList.put(player.getUuid(), player);
    }
    public void removePlayer(UUID uuid) {
        playerList.remove(uuid);
    }

    public FFAPlayerList getInstance() {
        return instance;
    }

    public static Map<UUID,FFAPlayer> getPlayers() {
        return playerList;
    }

    public static List<FFAPlayer> getPlayerList() {
        return new ArrayList(playerList.values());
    }

}
