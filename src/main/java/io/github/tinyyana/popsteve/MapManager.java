package io.github.tinyyana.popsteve;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class MapManager {
    public int totalPop;
    public UUID popPlayer;
    HashMap<UUID, Integer> totalPopMap = new HashMap<>();

    public void setTotalPopMap(HashMap<UUID, Integer> totalPopMap) {
        this.totalPopMap = totalPopMap;
        totalPopMap.put(popPlayer, totalPop);
    }

    public void load() {
        ConfigLoader data = PluginMain.getPlugin().data;
        for (String key : data.get().getKeys(false)) {
            String value = data.get().getString(key);
            if (key.equals("totalPop")) {
                continue;
            }
            totalPopMap.put(UUID.fromString(key), Integer.parseInt(value));
        }
    }
}

