package org.example.auz.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. largest-divisible-subset
 * https://leetcode.cn/problems/largest-divisible-subset/description/?show=1
 */
public class Num_368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] idx = new int[nums.length];
        Arrays.fill(idx, -1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = 1 + dp[j];
                        idx[i] = j;
                    }
                }
            }
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = idx[index];
        }
        return res;
    }
}
