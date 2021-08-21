package io.github.tinyyana.popsteve;

import java.util.HashMap;
import java.util.UUID;

public class MapManager {
    public int totalPop;
    HashMap<UUID, Integer> totalPopMap = new HashMap<>();

    public void setTotalPopMap(UUID popPlayer, Integer totalPop) {
        totalPopMap.put(popPlayer, totalPop);
    }

    public void load() {
        ConfigLoader data = PluginMain.getPlugin().data;
        for (String key : data.get().getKeys(false)) {
            String value = data.get().getString(key);
            if (key.equals("totalPop")) {
                data.get().set("totalPop", totalPop);
                continue;
            }
            totalPopMap.put(UUID.fromString(key), Integer.parseInt(value));
        }
    }

    public Integer getPop(UUID uuid) {
        return this.totalPopMap.get(uuid);
    }
}
