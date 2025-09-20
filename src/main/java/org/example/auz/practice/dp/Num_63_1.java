package org.example.auz.practice.dp;

/**
 * 63. unique-paths-ii
 * https://leetcode.cn/problems/unique-paths-ii/description/?show=1
 */
public class Num_63_1 {

    int m, n;
    int[][] memo;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;

        memo = new int[m][n];

        return dp(obstacleGrid, m - 1, n - 1);
    }

    private int dp(int[][] obstacleGrid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return 1;
        }

        if (memo[i][j] > 0) {
            return memo[i][j];
        }

        memo[i][j] = dp(obstacleGrid, i - 1, j) + dp(obstacleGrid, i, j - 1);

        return memo[i][j];
    }


}
