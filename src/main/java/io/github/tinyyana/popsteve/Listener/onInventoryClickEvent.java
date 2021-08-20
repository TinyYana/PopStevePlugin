package io.github.tinyyana.popsteve.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class onInventoryClickEvent implements Listener {


    @EventHandler
    public void onMainInventoryClick(InventoryClickEvent event) {
        if(!event.getView().getTitle().equals("Pop Steve :)")){
            return;
        }
        event.setCancelled(true);
        if(event.getSlot() == 13){

        }
    }



}
