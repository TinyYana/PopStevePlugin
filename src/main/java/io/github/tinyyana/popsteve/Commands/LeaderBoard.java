package io.github.tinyyana.popsteve.Commands;

import io.github.tinyyana.popsteve.PluginMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static io.github.tinyyana.popsteve.Listener.InventoryEvent.mapManager;

public class LeaderBoard implements CommandExecutor {
    public LeaderBoard(PluginMain pluginMain) {
    }

    public String playerFor;
    public Integer countFor;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        List<Integer> popCount = new ArrayList<>(mapManager.totalPopMap.values());
        List<UUID> popPlayer = new ArrayList(mapManager.totalPopMap.keySet());

        for (int i = 0; i < popPlayer.size(); i++) {
            playerFor = Bukkit.getPlayer(popPlayer.get(i)).getName();
        }
        for (int i = 0; i < popCount.size(); i++) {
            countFor = popCount.get(i);
        }

        player.sendMessage(ChatColor.BLUE + "------------------------------------");
        player.sendMessage("§61. §e" + playerFor + " §8Count: §7" + countFor);
        player.sendMessage(ChatColor.BLUE + "------------------------------------");

        return true;
    }
}
