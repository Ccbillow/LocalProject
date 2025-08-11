package org.example.auz.blind75.map;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 733. Flood Fill
 * https://leetcode.com/problems/flood-fill/description/
 *
 * time: O(m * n)
 * space: O(m * n)
 */
public class Num_733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor == color) {
            return image;
        }

        int m = image.length;
        int n = image[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{sr, sc});

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();

            int r = cur[0];
            int c = cur[1];
            if (r < 0 || r >= m || c < 0 || c >= n || image[r][c] != oldColor) {
                continue;
            }

            image[r][c] = color;
            deque.addLast(new int[]{r + 1, c});
            deque.addLast(new int[]{r - 1, c});
            deque.addLast(new int[]{r, c + 1});
            deque.addLast(new int[]{r, c - 1});
        }
        return image;
    }
}
