package org.example.auz.practice.backtrack;

/**
 * 1712. ways-to-split-array-into-three-subarrays
 * https://leetcode.cn/problems/ways-to-split-array-into-three-subarrays/description/
 */
public class Num_1712_3 {

    public int waysToSplit(int[] nums) {
        int n = nums.length;

        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        long res = 0;

        for (int i = 1; i <= n - 2; i++) {
            int left = preSum[i];

            //preSum[i] <= preSum[j] - preSum[i]
            int low = lower(preSum, 2 * left, i + 1, n - 1);

            //preSum[j] - preSum[i] <= preSum[n] - preSum[j]
            int high = higher(preSum, (preSum[n] + left) / 2, i + 1, n - 1);

            if (low <= high) {
                res += (long) (high - low + 1);
                res = res % 1_000_000_007;
            }
        }

        return (int) res;
    }

    private int higher(int[] preSum, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (preSum[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private int lower(int[] preSum, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (preSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
