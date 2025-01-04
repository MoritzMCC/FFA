package de.MoritzMCC.fFAPit;

import de.MoritzMCC.Listener.DeathListener;
import de.MoritzMCC.Listener.FFAListener;
import de.MoritzMCC.Listener.FightListener;
import de.MoritzMCC.arena.Mapmanager;
import de.MoritzMCC.arena.SkyBoarder;
import de.MoritzMCC.commands.SuicideCommand;
import de.MoritzMCC.kits.AnchorKit;
import de.MoritzMCC.kits.NinjaKit;
import de.hglabor.plugins.kitapi.KitApi;
import org.bukkit.Bukkit;
import org.bukkit.Material;
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
        registerKits();

    }

    private void registerEvents() {
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(new DeathListener(), this);
        manager.registerEvents(new FightListener(), this);
        manager.registerEvents(new FFAListener(), this);
    }
    private void registerCommands() {
        getCommand("suicide").setExecutor(new SuicideCommand());
    }
    private static void registerKits(){
      KitApi kitApi = KitApi.getInstance();
      kitApi.register(new AnchorKit("Anchor", Material.ANVIL));
      kitApi.register(new NinjaKit("Ninja", Material.INK_SAC));
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
