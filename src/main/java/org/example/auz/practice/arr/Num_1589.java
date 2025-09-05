package org.example.auz.practice.arr;

import java.util.Arrays;

/**
 * 1589. maximum-sum-obtained-of-any-permutation
 * https://leetcode.cn/problems/maximum-sum-obtained-of-any-permutation/description/
 */
public class Num_1589 {

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        final int MOD = 1_000_000_007;
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 0);

        Diff diff = new Diff(arr);
        for (int[] request : requests) {
            int from = request[0];
            int to = request[1];
            diff.increment(from, to, 1);
        }
        int[] diffRes = diff.result();

        Arrays.sort(nums);
        Arrays.sort(diffRes);

        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = (res + (long) diffRes[i] * nums[i]) % MOD;
        }
        return (int) res;
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
