package org.example.auz.practice.arr;

import java.util.Arrays;

/**
 * LeetCode 370. Range Addition
 */
public class Num_370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        Arrays.fill(arr, 0);

        Diff diff = new Diff(arr);
        for (int[] update : updates) {
            int from = update[0];
            int to = update[1];
            int val = update[2];
            diff.increment(from, to, val);
        }
        return diff.result();
    }

    class Diff {
        private int[] diff;

        public Diff(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increment(int i, int j, int val) {
            diff[i] = diff[i] + val;
            if (j < diff.length - 1) {
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
