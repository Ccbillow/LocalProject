package org.example.auz.practice.backtrack;

/**
 * 2305. fair-distribution-of-cookies
 * https://leetcode.cn/problems/fair-distribution-of-cookies/description/
 */
public class Num_2305 {

    int res = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        int[] children = new int[k];
        dfs(cookies, 0, children);
        return res;
    }

    private void dfs(int[] cookies, int idx, int[] children) {
        if (idx == cookies.length) {
            int max = 0;
            for (int child : children) {
                max = Math.max(child, max);
            }
            res = Math.min(res, max);
            return;
        }

        for (int i = 0; i < children.length; i++) {
            if (children[i] + cookies[idx] > res) {
                continue;
            }
            children[i] = children[i] + cookies[idx];
            dfs(cookies, idx + 1, children);
            children[i] = children[i] - cookies[idx];
        }
    }
}
