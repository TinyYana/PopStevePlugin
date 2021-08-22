package io.github.tinyyana.popsteve.Commands;

import io.github.tinyyana.popsteve.MapManager;
import io.github.tinyyana.popsteve.PluginMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class LeaderBoard implements CommandExecutor {
    public LeaderBoard(PluginMain pluginMain) {
    }

    MapManager mapManager = PluginMain.getPlugin().mapManager;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        sender.sendMessage(ChatColor.BLUE + "--------------§d§lPop Steve§r§9--------------");
        sender.sendMessage(ChatColor.GREEN + "Top 10 Pop");
        sender.sendMessage(ChatColor.GREEN + "Total Pops: " + mapManager.totalPop);

        List<Integer> popCount = new ArrayList<>(mapManager.totalPopMap.values());
        int i = 0;
        for (UUID uuid : mapManager.getList()) {
            if(i == 10){
                break;
            }
            sender.sendMessage("§61. §e" + Bukkit.getPlayer(uuid).getName() + " §8Count: §7" + mapManager.getPop(uuid));
            i++;
        }
        sender.sendMessage(ChatColor.BLUE + "-----------------------------------------");


        popCount.forEach(System.out::println);



        return true;
    }
}
