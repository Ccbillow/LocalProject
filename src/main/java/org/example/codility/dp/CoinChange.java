package org.example.codility.dp;

import java.util.*;

public class CoinChange {

    public int solution(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        int res = 0;
        for (int coin : coins) {
            int tmp = solution(coins, amount - coin);
            if (tmp >= 0) {
                res = tmp + 1;
            }
        }
        return res;
    }

    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(coins, amount, memo);
    }

    private int dfs(int[] coins, int remain, Map<Integer, Integer> memo) {
        if (remain < 0) return -1;
        if (remain == 0) return 0;

        if (memo.containsKey(remain)) return memo.get(remain);

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dfs(coins, remain - coin, memo);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }

        int result = (min == Integer.MAX_VALUE) ? -1 : min;
        memo.put(remain, result); // 记忆化
        return result;
    }
}
