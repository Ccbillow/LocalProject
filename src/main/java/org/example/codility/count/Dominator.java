package org.example.codility.count;

import java.util.HashMap;
import java.util.Map;

public class Dominator {

    public static int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }


        int value = getInteger(A, map);
        if (value == -1) {
            return -1;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] == value) {
                return i;
            }
        }

        return -1;
    }

    private static Integer getInteger(int[] A, Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > A.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
        System.out.println(solution(A));
    }
}
