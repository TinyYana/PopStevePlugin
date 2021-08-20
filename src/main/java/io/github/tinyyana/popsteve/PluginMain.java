package io.github.tinyyana.popsteve;

import io.github.tinyyana.popsteve.Commands.LeaderBoard;
import io.github.tinyyana.popsteve.Commands.PopSteveMenu;
import io.github.tinyyana.popsteve.Listener.onInventoryClickEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PluginMain extends JavaPlugin {

    public static PluginMain plugin;
    public ConfigLoader config;

    PluginManager pluginManager = getServer().getPluginManager();

    @Override
    public void onEnable() {
        loadCommands();
        loadEvents();
        config = new ConfigLoader("config");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void loadCommands() {
        getCommand("popsteve").setExecutor(new PopSteveMenu(this));
        getCommand("popleaderboard").setExecutor(new LeaderBoard(this));
    }

    public void loadEvents() {
        pluginManager.registerEvents(new onInventoryClickEvent(), this);
    }

    public void onLoad(){
        plugin = this;
    }

    public static PluginMain getPlugin(){
        return plugin;
    }

}
