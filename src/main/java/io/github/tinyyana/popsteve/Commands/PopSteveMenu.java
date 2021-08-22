package io.github.tinyyana.popsteve.Commands;

import io.github.tinyyana.popsteve.PluginMain;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PopSteveMenu implements CommandExecutor {

    Inventory popGui = Bukkit.createInventory(null,27, "§lPop Steve :)");

    public PopSteveMenu(PluginMain pluginMain) {
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only player can execute this command!");
            return true;
        }

        Player player = (Player) sender;
        UUID uuid = player.getUniqueId();
        player.openInventory(getPopGUI(uuid));
        return true;
    }

    public Inventory getPopGUI(UUID uuid){
        for(int i = 0;i<=26;i++){
            if (i == 13){
                continue;
            }
            putButton(Material.BLACK_STAINED_GLASS_PANE,"§7§lNO...NOT ME",null,i);
        }
        return popGui;
    }

    public void putButton(Material material, String name, List<String> lore, int index) {
        ItemStack button = new ItemStack(material, 1);
        ItemMeta meta = button.getItemMeta();
        meta.setDisplayName(name);
        if (lore != null) {
            meta.setLore(turnColorCode(lore));
        }
        button.setItemMeta(meta);
        popGui.setItem(index, button);
    }

    public List<String> turnColorCode(List<String> list) {
        List<String> lore = new ArrayList<>();
        for (String s : list) {
            lore.add(s.replace('&', '§'));
        }
        return lore;
    }
}
