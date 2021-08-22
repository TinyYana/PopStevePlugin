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
import java.util.Map;
import java.util.UUID;


public class LeaderBoard implements CommandExecutor {
    public LeaderBoard(PluginMain pluginMain) {
    }

    public String playerName;
    public Integer totalCounts;
    MapManager mapManager = PluginMain.getPlugin().mapManager;


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        List<Integer> popCount = new ArrayList<>(mapManager.totalPopMap.values());
        List<UUID> popPlayer = new ArrayList<>(mapManager.totalPopMap.keySet());

        for (int i = 0; i < popPlayer.size(); i++) {
            playerName = Bukkit.getPlayer(popPlayer.get(i)).getName();
        }
        for (int i = 0; i < popCount.size(); i++) {
            totalCounts = popCount.get(i);
        }



        sender.sendMessage(ChatColor.BLUE + "------------------------------------");
        for (UUID uuid : mapManager.getList()) {
            sender.sendMessage("§61. §e" + Bukkit.getPlayer(uuid).getName() + " §8Count: §7" + mapManager.getPop(uuid));
        }
        sender.sendMessage(ChatColor.BLUE + "------------------------------------");

        popCount.forEach(System.out::println);


        return true;
    }
}
