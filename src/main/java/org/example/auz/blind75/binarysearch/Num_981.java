package org.example.auz.blind75.binarysearch;

import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 981. Time Based Key-Value Store
 * https://leetcode.com/problems/time-based-key-value-store/description/
 *
 * O(1) for set()
 * O(log n) for get()
 */
public class Num_981 {

    private Map<String, List<Pair<Integer, String>>> map;

    public Num_981() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
//        map.computeIfAbsent(key, k -> new ArrayList<>())
//                .add(Pair.of(timestamp, value));
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(Pair.of(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return null;
        }

        List<Pair<Integer, String>> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        String res = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Integer midTime = list.get(mid).getFirst();
            if (midTime <= timestamp) {
                res = list.get(mid).getSecond();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
