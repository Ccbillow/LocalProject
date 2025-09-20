package org.example.auz.practice.dp;


/**
 * 377. combination-sum-iv
 * https://leetcode.cn/problems/combination-sum-iv/description/
 */
public class Num_377_2 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i >= n) {
                    dp[i] = dp[i] + dp[i - n];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Num_377_2 test = new Num_377_2();
        int[] nums = {1, 2, 3};
        test.combinationSum4(nums, 4);
    }
}
