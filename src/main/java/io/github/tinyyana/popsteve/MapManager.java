package io.github.tinyyana.popsteve;

import java.util.HashMap;
import java.util.UUID;

public class MapManager {
    public int totalPop;
    public UUID popPlayer;
    HashMap<UUID,Integer> totalPopMap = new HashMap<>();

    public void setTotalPopMap(HashMap<UUID, Integer> totalPopMap) {
        this.totalPopMap = totalPopMap;
        totalPopMap.put(popPlayer,totalPop);
    }
}
