package org.example.codility.arrays;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

    public static int missingInteger(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int n : A) {
            if (n > 0) {
                set.add(n);
            }
        }

        int res = 1;
        while (set.contains(res)) {
            res++;
        }
        return res;
    }

    public static int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            if (i > 0) set.add(i);
        }

        int res = 1;
        while (set.contains(res)) {
            res++;
        }
        return res;
    }
}
