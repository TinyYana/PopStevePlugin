package io.github.tinyyana.popsteve.Commands;

import io.github.tinyyana.popsteve.PluginMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

public class PopSteveMenu implements CommandExecutor {
    public PopSteveMenu(PluginMain pluginMain) {
    }
    Inventory popGui = Bukkit.createInventory(null,27, ChatColor.BOLD + "Pop Steve :)");
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;


        if (!(sender instanceof Player)) {
            sender.sendMessage("Only player can execute this command!");
            return true;
        }
        player.openInventory(getPopGUI());
        return false;
    }


    public Inventory getPopGUI(){

        for(int i = 0;i<=26;i++){
            if (i == 13){
                List<String> list = new ArrayList<>();
                list.add("&eClick to POP STEVE");
                putButton(Material.PLAYER_HEAD,"§6§lPOP STEVE!",list,i);
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
