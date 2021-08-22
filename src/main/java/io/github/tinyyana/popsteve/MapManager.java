package io.github.tinyyana.popsteve;

import java.util.*;

public class MapManager {
    public int totalPop = 0;
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
        for (int one = 0; one < popCount.length - 1; one++) {
            for (int two = 1; two < popCount.length; two++) {
                if (popCount[two] > popCount[one]) {
                    int num = popCount[one];
                    popCount[one] = popCount[two];
                    popCount[two] = num;
                }
            }
        }

        for (int i = 0; i <= 9; i++) {
            if (i + 1 == popCount.length) {
                break;
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
