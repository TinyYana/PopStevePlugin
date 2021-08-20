package io.github.tinyyana.popsteve.Commands;

import io.github.tinyyana.popsteve.PluginMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PopSteveMenu implements CommandExecutor {
    public PopSteveMenu(PluginMain pluginMain) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Inventory gui = Bukkit.createInventory(player,9, ChatColor.BOLD + "Pop Steve :)");

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only player can execute this command!");
            return true;
        }

        return false;
    }
}
