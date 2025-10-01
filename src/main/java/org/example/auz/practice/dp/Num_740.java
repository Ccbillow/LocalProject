package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 740. delete-and-earn
 * https://leetcode.cn/problems/delete-and-earn/description/
 */
public class Num_740 {

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] arr = new int[max + 1];
        for (int num : nums) {
            arr[num] += num;
        }

        int n = arr.length;

        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 0; i < n; i++) {
            dp[i + 2] = Math.max(dp[i + 1], dp[i] + arr[i]);
        }
        return dp[n + 1];
    }

    public static void main(String[] args) {
        Num_740 test = new Num_740();
        int[] arr = {2, 2, 3, 3, 3, 4};
        test.deleteAndEarn(arr);
    }
}
