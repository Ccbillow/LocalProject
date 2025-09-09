package org.example.auz.practice.backtrack;

/**
 * 980. unique-paths-iii
 * https://leetcode.cn/problems/unique-paths-iii/description/
 */
public class Num_980 {

    int m, n;
    boolean[][] visited;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int res = 0;
    int count = 0;

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        int x = 0;
        int y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
                if (grid[i][j] != -1) {
                    count++;
                }
            }
        }
        dfs(grid, x, y, 1);
        return res;
    }

    void dfs(int[][] grid, int x, int y, int cur) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }

        if (grid[x][y] == -1) {
            return;
        }

        if (visited[x][y]) {
            return;
        }

        if (grid[x][y] == 2) {
            if (cur == count) {
                res++;
            }
            return;
        }


        visited[x][y] = true;
        for (int[] dir : dirs) {
            int newx = x + dir[0];
            int newy = y + dir[1];
            dfs(grid, newx, newy, cur + 1);
        }
        visited[x][y] = false;
    }

    public static void main(String[] args) {
        Num_980 test = new Num_980();

        int[][] arr = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        System.out.println(test.uniquePathsIII(arr));
    }
}
