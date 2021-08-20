package io.github.tinyyana.popsteve.Listener;

import io.github.tinyyana.popsteve.MapManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class onInventoryClickEvent implements Listener {
    MapManager mapManager = new MapManager();

    @EventHandler
    public void onMainInventoryClick(InventoryClickEvent event) {
        if(!event.getView().getTitle().equals("Pop Steve :)")){
            return;
        }
        event.setCancelled(true);
        if(event.getSlot() == 13){
            mapManager.totalPop++;
        }
    }
}
