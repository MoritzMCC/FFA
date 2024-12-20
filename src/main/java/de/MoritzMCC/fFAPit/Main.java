package de.MoritzMCC.fFAPit;

import de.MoritzMCC.Listener.DeathListener;
import de.MoritzMCC.Listener.FightListener;
import de.MoritzMCC.arena.Mapmanager;
import de.MoritzMCC.arena.SkyBoarder;
import de.MoritzMCC.commands.SuicideCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
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
        registerEvents();
        registerCommands();

        SkyBoarder skyBoarder = new SkyBoarder(5, 130);
        mapmanager = new Mapmanager(Bukkit.getWorld("world"), 100);
    }

    private void registerEvents() {
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(new DeathListener(), this);
        manager.registerEvents(new FightListener(), this);
    }
    private void registerCommands() {
        getCommand("suicide").setExecutor(new SuicideCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getInstance() {
        return instance;
    }

    public static Mapmanager getMapmanager() {
        return mapmanager;
    }
}
