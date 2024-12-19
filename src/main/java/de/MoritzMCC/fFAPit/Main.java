package de.MoritzMCC.fFAPit;

import de.MoritzMCC.arena.Mapmanager;
import de.MoritzMCC.arena.SkyBoarder;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    static Plugin instance;
    static Mapmanager mapmanager;

    @Override
    public void onLoad() {
        instance = this;

    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        SkyBoarder skyBoarder = new SkyBoarder(5, 130);
        mapmanager = new Mapmanager(Bukkit.getWorld("world"), 100);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getInstance() {
        return instance;
    }

}
