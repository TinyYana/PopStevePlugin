package io.github.tinyyana.popsteve;

import io.github.tinyyana.popsteve.Commands.LeaderBoard;
import io.github.tinyyana.popsteve.Commands.PopSteveMenu;
import io.github.tinyyana.popsteve.Listener.InventoryEvent;
import io.github.tinyyana.popsteve.Listener.PlayerEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class PluginMain extends JavaPlugin {

    public static PluginMain plugin;
    public ConfigLoader data;

    PluginManager pluginManager = getServer().getPluginManager();
    public MapManager mapManager;

    @Override
    public void onEnable() {
        loadCommands();
        data = new ConfigLoader("data");
        mapManager.load();
        loadEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        data.save();
    }

    public void loadCommands() {
        getCommand("popsteve").setExecutor(new PopSteveMenu(this));
        getCommand("popleaderboard").setExecutor(new LeaderBoard(this));
    }

    public void loadEvents() {
        pluginManager.registerEvents(new InventoryEvent(), this);
        pluginManager.registerEvents(new PlayerEvent(), this);
    }

    public void onLoad() {
        plugin = this;
        mapManager = new MapManager();
    }

    public static PluginMain getPlugin() {
        return plugin;
    }

}
