package org.example.codility.arrays;

import java.util.HashMap;
import java.util.Map;

public class EquiLeader {

    public static int solution(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int value = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= a.length / 2) {
                value = entry.getKey();
            }
        }

        if (value == 0) {
            return 0;
        }

        int res = 0;
        int leftCount = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == value) {
                leftCount++;
            }

            int leftSize = i + 1;
            int rightSize = a.length - leftSize;

            int rightCount = value - leftCount;

            if (leftCount > leftSize / 2 && rightCount > rightSize / 2) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {4, 3, 4, 4, 4, 2};
        System.out.println(solution(a));
    }

    public static int leader(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int leader = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > a.length / 2) {
                leader = entry.getKey();
            }
        }

        if (leader == 0) {
            return 0;
        }

        int res = 0;
        int left = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == leader) {
                left++;
            }

            int leftSize = i + 1;
            int rightSize = a.length - leftSize;
            int right = leader - left;
            if (left > leftSize / 2 && right > rightSize / 2) {
                res++;
            }
        }

        return res;
    }
}
