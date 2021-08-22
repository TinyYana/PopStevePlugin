package io.github.tinyyana.popsteve.Listener;

import io.github.tinyyana.popsteve.Commands.PopSteveMenu;
import io.github.tinyyana.popsteve.ConfigLoader;
import io.github.tinyyana.popsteve.MapManager;
import io.github.tinyyana.popsteve.PluginMain;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InventoryEvent implements Listener {
    private final ConfigLoader data;
    private final PopSteveMenu popMenu;
    private final MapManager mapManager;

    public InventoryEvent() {
        data = PluginMain.getPlugin().data;
        popMenu = new PopSteveMenu(PluginMain.getPlugin());
        mapManager = PluginMain.plugin.mapManager;
    }

    @EventHandler
    public void onMainInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals("§lPop Steve :)")) return;
        event.setCancelled(true);

        if (event.getSlot() == 13) {
            UUID playerUUID = event.getWhoClicked().getUniqueId();
            List<String> list = new ArrayList<>();
            mapManager.totalPop++;

            Integer pop = mapManager.getPop(playerUUID);

            if (pop == null) {
                mapManager.setTotalPopMap(playerUUID, 1);
                list.add("&eClick to POP STEVE");
                list.add("&fYour POP: &7" + mapManager.getPop(playerUUID).toString());
                event.getInventory().setItem(13, setItem(Material.PLAYER_HEAD, "§6§lPOP STEVE!", list));
                data.get().set(playerUUID.toString(), 1);
                data.save();
                return;
            }
            mapManager.setTotalPopMap(playerUUID, pop + 1);
            data.get().set(playerUUID.toString(), pop);

            data.get().set("totalPop", mapManager.totalPop);
            list.add("&eClick to POP STEVE");
            list.add("&fYour POP: &7" + mapManager.getPop(playerUUID).toString());
            event.getInventory().setItem(13, setItem(Material.PLAYER_HEAD, "§6§lPOP STEVE!", list));

            event.getWhoClicked().sendMessage("§7§lPOP IT!!");
        }
    }

    @EventHandler
    public void onInventoryOpenEvent(InventoryOpenEvent event) {
        if (!event.getView().getTitle().equals("§lPop Steve :)")) return;

        UUID playerUUID = event.getPlayer().getUniqueId();
        List<String> list = new ArrayList<>();
        if (mapManager.getPop(playerUUID) == null) {
            mapManager.setTotalPopMap(playerUUID, 0);
            list.add("&eClick to POP STEVE");
            list.add("&fYour POP: &7" + mapManager.getPop(event.getPlayer().getUniqueId()).toString());
            event.getInventory().setItem(13, setItem(Material.PLAYER_HEAD, "§6§lPOP STEVE!", list));
            data.get().set(playerUUID.toString(), 0);
            data.save();
            return;
        }
        list.add("&eClick to POP STEVE");
        list.add("&fYour POP: &7" + mapManager.getPop(event.getPlayer().getUniqueId()).toString());
        list.add("&fTotal Pop: " + mapManager.totalPop);
        event.getInventory().setItem(13, setItem(Material.PLAYER_HEAD, "§6§lPOP STEVE!", list));
    }

    public ItemStack setItem(Material material, String name, List<String> lore) {
        ItemStack button = new ItemStack(material, 1);
        ItemMeta meta = button.getItemMeta();
        meta.setDisplayName(name);
        if (lore != null) {
            meta.setLore(popMenu.turnColorCode(lore));
        }
        button.setItemMeta(meta);
        return button;
    }

}
