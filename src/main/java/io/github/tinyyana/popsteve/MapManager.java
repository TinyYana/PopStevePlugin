package io.github.tinyyana.popsteve;

import java.util.HashMap;
import java.util.UUID;

public class MapManager {
    public int totalPop;
    public HashMap<UUID, Integer> totalPopMap = new HashMap<>();
    public MapManager mapManager;
    public void setTotalPopMap(UUID popPlayer, Integer totalPop) {
        totalPopMap.put(popPlayer, totalPop);
    }

    public void load() {
        ConfigLoader data = PluginMain.getPlugin().data;
        for (String key : data.get().getKeys(false)) {
            System.out.println("-------------------");
            System.out.println(key);
            String value = data.get().getString(key);
            System.out.println(value);
            if (key.equals("totalPop")) {
                totalPop = data.get().getInt("totalPop");
                System.out.println(totalPop);
                continue;
            }
            setTotalPopMap(UUID.fromString(key), Integer.parseInt(value));
            System.out.println(totalPopMap.get(UUID.fromString("204aff2a-ce18-4746-a8d3-33f9dc290543")));
            System.out.println(getPop(UUID.fromString("204aff2a-ce18-4746-a8d3-33f9dc290543")));
            System.out.println("-------------------");
        }
    }
    public Integer getPop(UUID uuid) {
        return this.totalPopMap.get(uuid);
    }

}
