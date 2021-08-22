package io.github.tinyyana.popsteve;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class MapManager {
    public int totalPop;
    public HashMap<UUID, Integer> totalPopMap = new HashMap<>();

    public void setTotalPopMap(UUID popPlayer, Integer totalPop) {
        totalPopMap.put(popPlayer, totalPop);
    }

    public void load() {
        ConfigLoader data = PluginMain.getPlugin().data;
        for (String key : data.get().getKeys(false)) {
            int value = data.get().getInt(key);
            if (key.equals("totalPop")) {
                totalPop = data.get().getInt("totalPop");
                System.out.println(totalPop);
                continue;
            }
            UUID uuid = UUID.fromString(key);
            setTotalPopMap(uuid, value);
        }
    }

    public Integer getPop(UUID uuid) {
        return this.totalPopMap.get(uuid);
    }

    public List<UUID> getList() {
        List<UUID> uuidList = new LinkedList<>();
        Integer[] popCount = this.totalPopMap.values().toArray(new Integer[0]);

        //排序
        for (int one = 0; one < popCount.length; one++) {
            for (int two = 1; two < popCount.length; two++) {
                if (one < two) {
                    int num = popCount[one];
                    popCount[one] = popCount[two];
                    popCount[two] = num;
                }
            }
        }

        //根據排序結果，按照順序添加UUID
        for (Integer count : popCount) {
            for (UUID uuid : this.totalPopMap.keySet()) {
                Integer integer = this.totalPopMap.get(uuid);
                if (integer.equals(count)) {
                    uuidList.add(uuid);
                }
            }
        }

        return uuidList;
    }
}
