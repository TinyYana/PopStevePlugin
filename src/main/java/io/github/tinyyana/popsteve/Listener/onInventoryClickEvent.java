package io.github.tinyyana.popsteve.Listener;

import io.github.tinyyana.popsteve.ConfigLoader;
import io.github.tinyyana.popsteve.MapManager;
import io.github.tinyyana.popsteve.PluginMain;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.UUID;

public class onInventoryClickEvent implements Listener {

    MapManager mapManager = new MapManager();
    ConfigLoader data = PluginMain.getPlugin().data;

    @EventHandler
    public void onMainInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals("§lPop Steve :)")) return;
        event.setCancelled(true);

        if (event.getSlot() == 13) {
            mapManager.totalPop++;
            UUID playerUUID = event.getWhoClicked().getUniqueId();
            if(mapManager.getPop(playerUUID) == null){
                mapManager.setTotalPopMap(playerUUID,1);
                data.get().set(playerUUID.toString(), 1);
                data.save();
            }
            mapManager.setTotalPopMap(playerUUID,mapManager.getPop(playerUUID) + 1);
            event.getWhoClicked().sendMessage("§7§lPOP IT!!");
        }
    }
}
