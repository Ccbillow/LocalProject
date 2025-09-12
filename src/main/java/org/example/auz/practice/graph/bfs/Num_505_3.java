package org.example.auz.practice.graph.bfs;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * The Maze II
 */
public class Num_505_3 {

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{start[0], start[1], 0});

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!pq.isEmpty()) {
            int[] curNode = pq.poll();
            int x = curNode[0];
            int y = curNode[1];
            int d = curNode[2];

            if (d > dist[x][y]) {
                continue;
            }

            for (int[] dir : dirs) {
                int newx = x;
                int newy = y;
                int nd = d;

                while (newx + dir[0] >= 0 && newx + dir[0] < m
                        && newy + dir[1] >= 0 && newy + dir[1] < n
                        && maze[newx + dir[0]][newy + dir[1]] == 0) {
                    newx = newx + dir[0];
                    newy = newy + dir[1];
                    nd++;
                }

                if (nd < dist[newx][newy]) {
                    dist[newx][newy] = nd;
                    pq.add(new int[]{newx, newy, nd});
                }
            }
        }

        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }


}
