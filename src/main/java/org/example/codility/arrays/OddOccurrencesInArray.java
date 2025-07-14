package org.example.codility.arrays;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {

    public static int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            if (!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                map.put(a, 0);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
