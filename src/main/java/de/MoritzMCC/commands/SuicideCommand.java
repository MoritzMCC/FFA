package de.MoritzMCC.commands;

import de.MoritzMCC.ffaPlayer.FFAPlayer;
import de.MoritzMCC.ffaPlayer.FFAPlayerList;
import de.MoritzMCC.ffaPlayer.Status;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SuicideCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("You have to be a player to execute this command!");
        }
        Player player = (Player) commandSender;
        FFAPlayer ffaPlayer = FFAPlayerList.getPlayer(player.getUniqueId());
        if(ffaPlayer== null) return true;
        if(System.currentTimeMillis() - ffaPlayer.getEnemyHit().getValue() > 1000*30){
            player.sendMessage("You are still in combat");
            return true;
        }
        if(!(ffaPlayer.getStatus().equals(Status.InArena))){
            player.sendMessage("You are not in arena");
            return true;
        }
        player.getInventory().clear();
        player.setHealth(0);


        return false;
    }
}
