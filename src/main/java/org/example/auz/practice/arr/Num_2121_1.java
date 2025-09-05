package org.example.auz.practice.arr;

import java.util.Arrays;

/**
 * 2121. Intervals Between Identical Elements
 * https://leetcode.com/problems/intervals-between-identical-elements/description/
 */
public class Num_2121_1 {

    public long[] getDistances(int[] arr) {
        long[] res = new long[arr.length];


        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            long distance = 0;
            for (int j = 0; j < arr.length; j++) {

                int y = arr[j];
                if (x == y) {
                    distance = distance + Math.abs(j - i);
                }
            }
            res[i] = distance;
        }
        return res;
    }

    public static void main(String[] args) {
        Num_2121_1 test = new Num_2121_1();
//        int[] arr = {2, 1, 3, 1, 2, 3, 3};
        int[] arr = {10, 5, 10, 10};
        System.out.println(Arrays.toString(test.getDistances(arr)));
    }
}
