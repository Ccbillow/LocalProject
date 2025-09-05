package org.example.auz.practice.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2121. Intervals Between Identical Elements
 * https://leetcode.com/problems/intervals-between-identical-elements/description/
 */
public class Num_2121_2 {

    public long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }

        long[] res = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            long distance = 0;
            for (Integer cur : map.get(arr[i])) {
                distance = distance + Math.abs(i - cur);
            }
            res[i] = distance;
        }
        return res;
    }

    public static void main(String[] args) {
        Num_2121_2 test = new Num_2121_2();
        int[] arr = {2, 1, 3, 1, 2, 3, 3};
//        int[] arr = {10, 5, 10, 10};
        System.out.println(Arrays.toString(test.getDistances(arr)));
    }
}
