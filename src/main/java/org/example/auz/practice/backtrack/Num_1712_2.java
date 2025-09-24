package org.example.auz.practice.backtrack;

/**
 * 1712. ways-to-split-array-into-three-subarrays
 * https://leetcode.cn/problems/ways-to-split-array-into-three-subarrays/description/
 */
public class Num_1712_2 {

    public int waysToSplit(int[] nums) {
        int n = nums.length;

        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        long res = 0;
        int j = 0, k = 0;

        for (int i = 1; i <= n - 2; i++) {
            // left
            int left = preSum[i];

            // mid: find first index of sum(mid) >= left
            j = Math.max(j, i + 1);
            while (j < n && preSum[j] - preSum[i] < left) {
                j++;
            }

            // right:
            k = Math.max(k, j);
            while (k < n && preSum[k] - preSum[i] <= preSum[n] - preSum[k]) {
                k++;
            }

            res += (long) (k - j);
        }


        return (int) (res % 1_000_000_007);
    }
}
