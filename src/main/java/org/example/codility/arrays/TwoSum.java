package org.example.codility.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] solution(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[]{map.get(target - arr[i]), i};
            }
            map.put(target - arr[i], i);
        }

        return new int[2];
    }
}
