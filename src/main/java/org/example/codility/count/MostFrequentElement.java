package org.example.codility.count;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentElement {

    public static int soulution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int frequent = 0;
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > frequent) {
                frequent = entry.getValue();
                res = entry.getKey();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 5, 6, 3, 2, 4, 6, 4, 7, 1};
        System.out.println(soulution(A));
        System.out.println(frequent(A));
    }

    public static int frequent(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int max = 0;
        int key = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                key = entry.getKey();
            }
        }

        return key;
    }
}
