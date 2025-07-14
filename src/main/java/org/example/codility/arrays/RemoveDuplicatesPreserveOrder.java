package org.example.codility.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Input:  [4, 5, 4, 2, 3, 5, 1, 2]
 * Output: [4, 5, 2, 3, 1]
 */
public class RemoveDuplicatesPreserveOrder {

    public static int[] solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i : A) {
            if (!set.contains(i)) {
                set.add(i);
                list.add(i);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 4, 2, 3, 5, 1, 2};
        System.out.println(Arrays.toString(solution(arr)));
    }
}
