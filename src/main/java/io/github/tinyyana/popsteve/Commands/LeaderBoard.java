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

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        List<Integer> popCount = new ArrayList<>(mapManager.totalPopMap.values());
        List<UUID> popPlayer = new ArrayList(mapManager.totalPopMap.keySet());

        player.sendMessage(ChatColor.BLUE + "------------------------------------");
        if (popPlayer.size() == 1 || popCount.size() == 1) {
            player.sendMessage("§61. §e" + Bukkit.getPlayer(popPlayer.get(0)).getName() + " §8Count: §7" + popCount.get(0));
        }
        if (popPlayer.size() == 2 || popCount.size() == 2) {
            player.sendMessage("§61. §e" + Bukkit.getPlayer(popPlayer.get(0)).getName() + " §8Count: §7" + popCount.get(0));
            player.sendMessage("§62. §e" + Bukkit.getPlayer(popPlayer.get(1)).getName() + " §8Count: §7" + popCount.get(1));
        }
        if (popPlayer.size() == 3 || popCount.size() == 3) {
            player.sendMessage("§61. §e" + Bukkit.getPlayer(popPlayer.get(0)).getName() + " §8Count: §7" + popCount.get(0));
            player.sendMessage("§62. §e" + Bukkit.getPlayer(popPlayer.get(1)).getName() + " §8Count: §7" + popCount.get(1));
            player.sendMessage("§63. §e" + Bukkit.getPlayer(popPlayer.get(2)).getName() + " §8Count: §7" + popCount.get(2));
        }
        if (popPlayer.size() == 4 || popCount.size() == 4) {
            player.sendMessage("§61. §e" + Bukkit.getPlayer(popPlayer.get(0)).getName() + " §8Count: §7" + popCount.get(0));
            player.sendMessage("§62. §e" + Bukkit.getPlayer(popPlayer.get(1)).getName() + " §8Count: §7" + popCount.get(1));
            player.sendMessage("§63. §e" + Bukkit.getPlayer(popPlayer.get(2)).getName() + " §8Count: §7" + popCount.get(2));
            player.sendMessage("§64. §e" + Bukkit.getPlayer(popPlayer.get(3)).getName() + " §8Count: §7" + popCount.get(3));
        }
        if (popPlayer.size() == 5 || popCount.size() == 5) {
            player.sendMessage("§61. §e" + Bukkit.getPlayer(popPlayer.get(0)).getName() + " §8Count: §7" + popCount.get(0));
            player.sendMessage("§62. §e" + Bukkit.getPlayer(popPlayer.get(1)).getName() + " §8Count: §7" + popCount.get(1));
            player.sendMessage("§63. §e" + Bukkit.getPlayer(popPlayer.get(2)).getName() + " §8Count: §7" + popCount.get(2));
            player.sendMessage("§64. §e" + Bukkit.getPlayer(popPlayer.get(3)).getName() + " §8Count: §7" + popCount.get(3));
            player.sendMessage("§65. §e" + Bukkit.getPlayer(popPlayer.get(4)).getName() + " §8Count: §7" + popCount.get(4));
        }
        if (popPlayer.size() == 6 || popCount.size() == 6) {
            player.sendMessage("§61. §e" + Bukkit.getPlayer(popPlayer.get(0)).getName() + " §8Count: §7" + popCount.get(0));
            player.sendMessage("§62. §e" + Bukkit.getPlayer(popPlayer.get(1)).getName() + " §8Count: §7" + popCount.get(1));
            player.sendMessage("§63. §e" + Bukkit.getPlayer(popPlayer.get(2)).getName() + " §8Count: §7" + popCount.get(2));
            player.sendMessage("§64. §e" + Bukkit.getPlayer(popPlayer.get(3)).getName() + " §8Count: §7" + popCount.get(3));
            player.sendMessage("§65. §e" + Bukkit.getPlayer(popPlayer.get(4)).getName() + " §8Count: §7" + popCount.get(4));
            player.sendMessage("§66. §e" + Bukkit.getPlayer(popPlayer.get(5)).getName() + " §8Count: §7" + popCount.get(5));
        }
        if (popPlayer.size() == 7 || popCount.size() == 7) {
            player.sendMessage("§61. §e" + Bukkit.getPlayer(popPlayer.get(0)).getName() + " §8Count: §7" + popCount.get(0));
            player.sendMessage("§62. §e" + Bukkit.getPlayer(popPlayer.get(1)).getName() + " §8Count: §7" + popCount.get(1));
            player.sendMessage("§63. §e" + Bukkit.getPlayer(popPlayer.get(2)).getName() + " §8Count: §7" + popCount.get(2));
            player.sendMessage("§64. §e" + Bukkit.getPlayer(popPlayer.get(3)).getName() + " §8Count: §7" + popCount.get(3));
            player.sendMessage("§65. §e" + Bukkit.getPlayer(popPlayer.get(4)).getName() + " §8Count: §7" + popCount.get(4));
            player.sendMessage("§66. §e" + Bukkit.getPlayer(popPlayer.get(5)).getName() + " §8Count: §7" + popCount.get(5));
            player.sendMessage("§67. §e" + Bukkit.getPlayer(popPlayer.get(6)).getName() + " §8Count: §7" + popCount.get(6));
        }
        if (popPlayer.size() == 8 || popCount.size() == 8) {
            player.sendMessage("§61. §e" + Bukkit.getPlayer(popPlayer.get(0)).getName() + " §8Count: §7" + popCount.get(0));
            player.sendMessage("§62. §e" + Bukkit.getPlayer(popPlayer.get(1)).getName() + " §8Count: §7" + popCount.get(1));
            player.sendMessage("§63. §e" + Bukkit.getPlayer(popPlayer.get(2)).getName() + " §8Count: §7" + popCount.get(2));
            player.sendMessage("§64. §e" + Bukkit.getPlayer(popPlayer.get(3)).getName() + " §8Count: §7" + popCount.get(3));
            player.sendMessage("§65. §e" + Bukkit.getPlayer(popPlayer.get(4)).getName() + " §8Count: §7" + popCount.get(4));
            player.sendMessage("§66. §e" + Bukkit.getPlayer(popPlayer.get(5)).getName() + " §8Count: §7" + popCount.get(5));
            player.sendMessage("§67. §e" + Bukkit.getPlayer(popPlayer.get(6)).getName() + " §8Count: §7" + popCount.get(6));
            player.sendMessage("§68. §e" + Bukkit.getPlayer(popPlayer.get(7)).getName() + " §8Count: §7" + popCount.get(7));
        }
        if (popPlayer.size() == 9 || popCount.size() == 9) {
            player.sendMessage("§61. §e" + Bukkit.getPlayer(popPlayer.get(0)).getName() + " §8Count: §7" + popCount.get(0));
            player.sendMessage("§62. §e" + Bukkit.getPlayer(popPlayer.get(1)).getName() + " §8Count: §7" + popCount.get(1));
            player.sendMessage("§63. §e" + Bukkit.getPlayer(popPlayer.get(2)).getName() + " §8Count: §7" + popCount.get(2));
            player.sendMessage("§64. §e" + Bukkit.getPlayer(popPlayer.get(3)).getName() + " §8Count: §7" + popCount.get(3));
            player.sendMessage("§65. §e" + Bukkit.getPlayer(popPlayer.get(4)).getName() + " §8Count: §7" + popCount.get(4));
            player.sendMessage("§66. §e" + Bukkit.getPlayer(popPlayer.get(5)).getName() + " §8Count: §7" + popCount.get(5));
            player.sendMessage("§67. §e" + Bukkit.getPlayer(popPlayer.get(6)).getName() + " §8Count: §7" + popCount.get(6));
            player.sendMessage("§68. §e" + Bukkit.getPlayer(popPlayer.get(7)).getName() + " §8Count: §7" + popCount.get(7));
            player.sendMessage("§69. §e" + Bukkit.getPlayer(popPlayer.get(8)).getName() + " §8Count: §7" + popCount.get(8));
        }
        if (popPlayer.size() == 10 || popCount.size() == 10) {
            player.sendMessage("§61. §e" + Bukkit.getPlayer(popPlayer.get(0)).getName() + " §8Count: §7" + popCount.get(0));
            player.sendMessage("§62. §e" + Bukkit.getPlayer(popPlayer.get(1)).getName() + " §8Count: §7" + popCount.get(1));
            player.sendMessage("§63. §e" + Bukkit.getPlayer(popPlayer.get(2)).getName() + " §8Count: §7" + popCount.get(2));
            player.sendMessage("§64. §e" + Bukkit.getPlayer(popPlayer.get(3)).getName() + " §8Count: §7" + popCount.get(3));
            player.sendMessage("§65. §e" + Bukkit.getPlayer(popPlayer.get(4)).getName() + " §8Count: §7" + popCount.get(4));
            player.sendMessage("§66. §e" + Bukkit.getPlayer(popPlayer.get(5)).getName() + " §8Count: §7" + popCount.get(5));
            player.sendMessage("§67. §e" + Bukkit.getPlayer(popPlayer.get(6)).getName() + " §8Count: §7" + popCount.get(6));
            player.sendMessage("§68. §e" + Bukkit.getPlayer(popPlayer.get(7)).getName() + " §8Count: §7" + popCount.get(7));
            player.sendMessage("§69. §e" + Bukkit.getPlayer(popPlayer.get(8)).getName() + " §8Count: §7" + popCount.get(8));
            player.sendMessage("§610. §e" + Bukkit.getPlayer(popPlayer.get(9)).getName() + " §8Count: §7" + popCount.get(9));
        }
        player.sendMessage(ChatColor.BLUE + "------------------------------------");

        return true;
    }
}
