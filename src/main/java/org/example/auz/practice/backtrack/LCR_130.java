package org.example.auz.practice.backtrack;

import java.security.Key;

/**
 * LCR 130. 衣橱整理
 * https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/description/?show=1
 */
public class LCR_130 {

    int m, n;

    boolean[][] visited;

    public int wardrobeFinishing(int m, int n, int cnt) {
        this.m = m;
        this.n = n;
        visited = new boolean[m][n];

        return dfs(0, 0, cnt);
    }

    private int dfs(int x, int y, int cnt) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 0;
        }

        if (x / 10 + x % 10 + y / 10 + y % 10 > cnt) {
            return 0;
        }

        if (visited[x][y]) {
            return 0;
        }

        visited[x][y] = true;

        return 1 + dfs(x + 1, y, cnt) + dfs(x, y + 1, cnt);
    }

}
