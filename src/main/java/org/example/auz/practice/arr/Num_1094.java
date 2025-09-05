package org.example.auz.practice.arr;

import java.util.Arrays;

/**
 * 1094. car-pooling
 *
 * https://leetcode.cn/problems/car-pooling/description/
 */
public class Num_1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];
        Arrays.fill(arr, 0);

        Diff diff = new Diff(arr);
        for (int[] trip : trips) {
            int num = trip[0];
            int from = trip[1];
            int to = trip[2] - 1;
            diff.increment(from, to, num);
        }

        int[] res = diff.result();
        for (int i = 0; i < res.length; i++) {
            if (capacity < res[i]) {
                return false;
            }
        }
        return true;
    }

    class Diff {
        int[] diff;

        public Diff(int[] arr) {
            diff = new int[arr.length];
            diff[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                diff[i] = arr[i] - arr[i - 1];
            }
        }

        public void increment(int i, int j, int val) {
            diff[i] = diff[i] + val;
            if (j + 1 < diff.length) {
                diff[j + 1] = diff[j + 1] - val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
}
