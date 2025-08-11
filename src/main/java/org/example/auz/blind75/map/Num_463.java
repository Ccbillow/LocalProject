package org.example.auz.blind75.map;

/**
 * 463. Island Perimeter
 * https://leetcode.com/problems/island-perimeter/description/
 *
 * time: O(m * n)
 * space: O(1)
 */
public class Num_463 {

    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    res = res + 4;

                    if (i > 0 && grid[i - 1][j] == 1) {
                        res = res - 2;
                    }

                    if (j > 0 && grid[i][j - 1] == 1) {
                        res = res - 2;
                    }
                }
            }
        }
        return res;
    }
}
