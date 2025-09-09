package org.example.auz.practice.backtrack;

/**
 * 79. 单词搜索
 * https://leetcode.cn/problems/word-search/description/?show=1
 */
public class Num_79 {

    int m, n;

    boolean res = false;

    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, word, i, j, 0);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    private void dfs(char[][] board, String word, int x, int y, int len) {
        if (len == word.length()) {
            res = true;
            return;
        }

        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }

        if (board[x][y] != word.charAt(len)) {
            return;
        }

        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        dfs(board, word, x + 1, y, len + 1);
        dfs(board, word, x - 1, y, len + 1);
        dfs(board, word, x, y + 1, len + 1);
        dfs(board, word, x, y - 1, len + 1);
        visited[x][y] = false;
    }


}
