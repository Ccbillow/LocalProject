package org.example.auz.practice.dp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 97. interleaving-string
 * https://leetcode.cn/problems/interleaving-string/description/?show=1
 */
public class Num_97_4 {


    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        boolean[][] visited = new boolean[m + 1][n + 1];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int x = cur[0];
            int y = cur[1];

            if (x == m && y == n) {
                return true;
            }

            int nx = x + 1;
            if (nx <= m && s1.charAt(nx - 1) == s3.charAt(nx + y - 1)) {
                if (!visited[nx][y]) {
                    visited[nx][y] = true;
                    q.addLast(new int[]{nx, y});
                }
            }

            int ny = y + 1;
            if (ny <= n && s2.charAt(ny - 1) == s3.charAt(x + ny - 1)) {
                if (!visited[x][ny]) {
                    visited[x][ny] = true;
                    q.addLast(new int[]{x, ny});
                }
            }
        }
        return false;
    }

}
