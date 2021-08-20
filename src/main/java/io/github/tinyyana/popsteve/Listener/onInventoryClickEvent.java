package io.github.tinyyana.popsteve.Listener;

import io.github.tinyyana.popsteve.MapManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.UUID;

public class onInventoryClickEvent implements Listener {
    MapManager mapManager = new MapManager();

    @EventHandler
    public void onMainInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals("§lPop Steve :)")) return;
        event.setCancelled(true);
        if(event.getSlot() == 13){
            mapManager.totalPop++;
            UUID playerUUID = event.getWhoClicked().getUniqueId();
            mapManager.popPlayer = playerUUID;
        }
    }
}
