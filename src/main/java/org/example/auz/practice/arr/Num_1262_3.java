package org.example.auz.practice.arr;

/**
 * greatest-sum-divisible-by-three
 * https://leetcode.cn/problems/greatest-sum-divisible-by-three/description/?show=1
 */
public class Num_1262_3 {

    public int maxSumDivThree(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n + 1][3];

        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int cur = nums[i - 1];
            if (cur % 3 == 0) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][0] + cur);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][1] + cur);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][2] + cur);
            } else if (cur % 3 == 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] + cur);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + cur);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + cur);
            } else if (cur % 3 == 2) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + cur);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] + cur);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + cur);
            }
        }
        
        return dp[n][0];
    }

    public static void main(String[] args) {
        Num_1262_3 test = new Num_1262_3();
        int[] arr = {3, 6, 5, 4};
        test.maxSumDivThree(arr);
    }
}
