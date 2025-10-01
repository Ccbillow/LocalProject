package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 2266. count-number-of-texts
 * https://leetcode.cn/problems/count-number-of-texts/description/
 */
public class Num_2266_2 {

    int[] memo;
    int mod = 1_000_000_007;
    int[] key = {0, 3, 3, 3, 3, 3, 3, 4, 3, 4};

    public int countTexts(String pressedKeys) {
        memo = new int[pressedKeys.length()];
        Arrays.fill(memo, -1);

        return dfs(pressedKeys, 0);
    }

    private int dfs(String pressedKeys, int idx) {
        if (idx == pressedKeys.length()) {
            return 1;
        }

        if (memo[idx] != -1) {
            return memo[idx];
        }

        int sum = 0;
        int num = pressedKeys.charAt(idx) - '0';
        int len = key[num];
        for (int i = 1; i <= len; i++) {
            if (idx + i > pressedKeys.length()) {
                break;
            }

            if (i > 1 && pressedKeys.charAt(idx) != pressedKeys.charAt(idx + i - 1)) {
                break;
            }

            sum = (sum + dfs(pressedKeys, idx + i)) % mod;
        }

        return memo[idx] = sum;
    }
}
