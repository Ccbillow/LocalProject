package org.example.auz.practice.backtrack;

import java.util.Arrays;

/**
 * 2305. fair-distribution-of-cookies
 * https://leetcode.cn/problems/fair-distribution-of-cookies/description/
 */
public class Num_2305 {

    int res = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        Arrays.sort(cookies);
        reverse(cookies);

        int[] bucket = new int[k];
        dfs(cookies, 0, bucket);
        return res;
    }

    private void dfs(int[] cookies, int idx, int[] bucket) {
        if (idx == cookies.length) {
            int max = 0;
            for (int b : bucket) {
                max = Math.max(b, max);
            }
            res = Math.min(res, max);
            return;
        }

        int cookie = cookies[idx];
        for (int i = 0; i < bucket.length; i++) {
            // 剪枝1: 当前分配会超过最优值
            if (bucket[i] + cookie > res) {
                continue;
            }

            bucket[i] += cookie;
            dfs(cookies, idx + 1, bucket);
            bucket[i] -= cookie;

            // 剪枝2: 对称空桶只尝试一次
            if (bucket[i] == 0) break;
        }
    }

    private void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

}
