package org.example.auz.practice.dp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 1824. minimum-sideway-jumps
 * https://leetcode.cn/problems/minimum-sideway-jumps/description/
 */
public class Num_1824_3 {

    public int minSideJumps(int[] obstacles) {
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{2, 0, 0});

        int[][] dist = new int[4][obstacles.length + 1];
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dist[2][0] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int x = cur[0];
            int y = cur[1];
            int time = cur[2];

            if (y == obstacles.length - 1) {
                return time;
            }

            // right
            if (obstacles[y + 1] != x) {
                if (time < dist[x][y + 1]) {
                    q.addLast(new int[]{x, y + 1, time});
                    dist[x][y + 1] = time;
                }
                // up/down
            } else {
                for (int nx = 1; nx <= 3; nx++) {
                    if (nx == x) continue;

                    if (obstacles[y] == nx) continue;

                    if (time + 1 < dist[nx][y]) {
                        q.addLast(new int[]{nx, y, time + 1});
                        dist[nx][y] = time + 1;
                    }
                }
            }
        }
        return -1;
    }
}

