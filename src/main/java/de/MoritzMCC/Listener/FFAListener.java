package de.MoritzMCC.Listener;

import de.MoritzMCC.arena.Mapmanager;
import de.MoritzMCC.fFAPit.Main;
import de.MoritzMCC.ffaPlayer.FFAPlayer;
import de.MoritzMCC.ffaPlayer.FFAPlayerList;
import de.MoritzMCC.ffaPlayer.Status;
import de.MoritzMCC.utils.ItemBuilder;
import de.hglabor.plugins.kitapi.KitApi;
import de.hglabor.plugins.kitapi.kit.AbstractKit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Locale;

public class FFAListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        if(event.getItem() == null) return;
        Player player = event.getPlayer();
        Mapmanager mapmanager = Main.getMapmanager();
        ItemStack item = player.getInventory().getItemInMainHand();
        if(event.getItem().equals(new ItemBuilder(Material.MAP).withName(ChatColor.AQUA + "Teleport to arena").build())){
            FFAPlayer ffaPlayer = FFAPlayerList.getPlayer(player.getUniqueId());
            if (ffaPlayer == null) return;
            ffaPlayer.setStatus(Status.InArena);
            player.setGameMode(GameMode.SURVIVAL);
            player.setHealth(player.getMaxHealth());
            player.setFoodLevel(20);
            mapmanager.setEquipment(player);
            player.teleport(mapmanager.getRandomSpawnLocation());
            return;
        }
        if(item.equals(new ItemBuilder(Material.CHEST).withName(ChatColor.GOLD + "Kit Selection").build())){
            event.setCancelled(true);
            player.openInventory(KitList());
            return;
        }
    }
    private Inventory KitList(){
        Inventory inventory = Bukkit.createInventory(null, 7*9, ChatColor.GOLD + "Kit Selection");
        for (AbstractKit kit : KitApi.getInstance().getAllKits()){
            inventory.addItem(kit.getDisplayItem(Locale.forLanguageTag("en")));
        }
        return inventory;
    }

}
