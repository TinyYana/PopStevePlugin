package io.github.tinyyana.popsteve.Commands;

import io.github.tinyyana.popsteve.MapManager;
import io.github.tinyyana.popsteve.PluginMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoard implements CommandExecutor {
    public LeaderBoard(PluginMain pluginMain) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        MapManager mapManager = new MapManager();
        List<Integer> popCount = new ArrayList<>(mapManager.totalPopMap.values());
        popCount.forEach(System.out::println);

        return true;
    }
}
