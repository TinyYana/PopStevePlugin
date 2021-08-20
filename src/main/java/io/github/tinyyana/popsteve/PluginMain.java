package io.github.tinyyana.popsteve;

import io.github.tinyyana.popsteve.Commands.PopSteveMenu;
import org.bukkit.plugin.java.JavaPlugin;

public final class PluginMain extends JavaPlugin {

    @Override
    public void onEnable() {
        loadCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void loadCommands() {
        getCommand("popsteve").setExecutor(new PopSteveMenu(this));
    }
}
