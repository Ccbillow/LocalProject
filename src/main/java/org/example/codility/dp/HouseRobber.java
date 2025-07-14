package org.example.codility.dp;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
    public static int rob(int[] num) {
        return helper(num, num.length - 1);
    }

    private static int helper(int[] num, int i) {
        if (i < 0) {
            return 0;
        }

        return Math.max(helper(num, i - 1), helper(num, i - 2) + num[i]);
    }

    public static int rob2(int[] num) {
        Map<Integer, Integer> map = new HashMap<>();
        return helper2(num, num.length - 1, map);
    }

    private static int helper2(int[] num, int i, Map<Integer, Integer> map) {
        if (i < 0) {
            return 0;
        }

        if (map.get(i) != null) {
            return map.get(i);
        }

        int value = Math.max(helper2(num, i - 1, map), helper2(num, i - 2, map) + num[i]);
        map.put(i, value);
        return value;
    }
}
