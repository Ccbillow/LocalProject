package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 967. numbers-with-same-consecutive-differences
 * https://leetcode.cn/problems/numbers-with-same-consecutive-differences/description/?show=1
 */
public class Num_967_1 {

    List<Integer> res = new ArrayList<>();

    int stack = 0;
    int cur = 0;

    public int[] numsSameConsecDiff(int n, int k) {
        dfs(n, k);

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private void dfs(int n, int k) {
        if (cur == n) {
            res.add(stack);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (i == 0 && cur == 0) {
                continue;
            }

            if (cur > 0 && Math.abs(i - stack % 10) != k) {
                continue;
            }


            stack = stack * 10 + i;
            cur++;
            dfs(n, k);
            cur--;
            stack = (stack - i) / 10;
        }
    }


}
