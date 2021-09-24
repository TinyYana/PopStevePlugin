package io.github.tinyyana.popsteve.Listener;

import io.github.tinyyana.popsteve.ConfigLoader;
import io.github.tinyyana.popsteve.PluginMain;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class PlayerEvent implements Listener {

    ConfigLoader data = PluginMain.getPlugin().data;

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        data.save();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

    }
}
