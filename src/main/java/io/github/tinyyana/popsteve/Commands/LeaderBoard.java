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
        sender.sendMessage(ChatColor.GREEN + "前十排行榜");
        sender.sendMessage(ChatColor.GREEN + "全服推數: " + mapManager.totalPop);

        int runNumber = Math.min(mapManager.getList().size(), 10);

        for (int i = 0; i < runNumber; i++) {

            sender.sendMessage("§6" + (i + 1) + ". §e" + Bukkit.getPlayer(mapManager.getList().get(i)).getName() + " §8推數: §7" + mapManager.getPop(mapManager.getList().get(i)));
        }

        sender.sendMessage(ChatColor.BLUE + "-----------------------------------------");





        return true;
    }
}
