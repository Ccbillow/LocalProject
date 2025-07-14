package org.example.codility.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Input:  A = [4, 1, 3, 2]
 * Output: 1  // It's a permutation.
 *
 * Input:  A = [4, 1, 3]
 * Output: 0  // Missing 2, so not a permutation.
 */
public class PermCheck {

    public static boolean solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i : A) {
            if (set.contains(i)) {
                return false;
            }

            set.add(i);
            max = Math.max(max, i);
        }

        return max == A.length;
    }

    public static boolean check(int[] A) {
        Set<Integer> set = new HashSet<>();

        int max = 0;
        for (int i : A) {
            if (set.contains(i)) {
                return false;
            }

            set.add(i);
            max = Math.max(max, i);
        }
        return max == A.length;
    }
}
