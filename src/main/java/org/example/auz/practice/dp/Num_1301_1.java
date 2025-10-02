package org.example.auz.practice.dp;

import java.util.List;

/**
 * 1301. number-of-paths-with-max-score
 * https://leetcode.cn/problems/number-of-paths-with-max-score/description/
 */
public class Num_1301_1 {

    int n;
    Integer[][] maxMemo;
    Integer[][] cntMemo;
    int mod = 1_000_000_007;

    public int[] pathsWithMaxScore(List<String> board) {
        n = board.size();
        maxMemo = new Integer[n][n];
        cntMemo = new Integer[n][n];

        int[] res = dfs(board, n - 1, n - 1);

        return res[0] < 0 ? new int[]{0, 0} : new int[]{res[0], res[1]};
    }

    private int[] dfs(List<String> board, int i, int j) {
        if (i < 0 || j < 0) {
            return new int[]{Integer.MIN_VALUE, 0};
        }

        if (board.get(i).charAt(j) == 'X') {
            return new int[]{Integer.MIN_VALUE, 0};
        }

        if (i == 0 && j == 0) {
            return new int[]{0, 1};
        }

        if (maxMemo[i][j] != null) {
            return new int[]{maxMemo[i][j], cntMemo[i][j]};
        }

        int val = board.get(i).charAt(j) == 'S' ? 0 : (board.get(i).charAt(j) - '0');

        int[] left = dfs(board, i, j - 1);
        int[] up = dfs(board, i - 1, j);
        int[] leftUp = dfs(board, i - 1, j - 1);

        int best = Math.max(leftUp[0], Math.max(left[0], up[0]));
        long cnt = 0;
        if (leftUp[0] == best) cnt += leftUp[1];
        if (up[0] == best) cnt += up[1];
        if (left[0] == best) cnt += left[1];
        cnt %= mod;

        maxMemo[i][j] = best < 0 ? Integer.MIN_VALUE : best + val;
        cntMemo[i][j] = best < 0 ? 0 : (int) cnt;

        return new int[]{maxMemo[i][j], cntMemo[i][j]};
    }

}
