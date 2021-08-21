package io.github.tinyyana.popsteve.Commands;

import io.github.tinyyana.popsteve.PluginMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static io.github.tinyyana.popsteve.Listener.InventoryEvent.mapManager;

public class LeaderBoard implements CommandExecutor {
    public LeaderBoard(PluginMain pluginMain) {
    }

    public String playerName;
    public Integer totalCounts;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        List<Integer> popCount = new ArrayList<>(mapManager.totalPopMap.values());

        List<UUID> popPlayer = new ArrayList<>(mapManager.totalPopMap.keySet());

        for (UUID uuid : popPlayer) {
            playerName = Bukkit.getPlayer(uuid).getName();
        }
        for (Integer integer : popCount) {
            totalCounts = integer;
        }

        sender.sendMessage(ChatColor.BLUE + "------------------------------------");
        sender.sendMessage("§61. §e" + playerName + " §8Count: §7" + totalCounts);
        sender.sendMessage(ChatColor.BLUE + "------------------------------------");

        popCount.forEach(System.out::println);
        

        return true;
    }
}
