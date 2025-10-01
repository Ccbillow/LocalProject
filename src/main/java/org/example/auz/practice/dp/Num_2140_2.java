package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 2140. solving-questions-with-brainpower
 * https://leetcode.cn/problems/solving-questions-with-brainpower/description/?show=1
 */
public class Num_2140_2 {

    long[] memo;

    public long mostPoints(int[][] questions) {
        memo = new long[questions.length];
        Arrays.fill(memo, -1);

        return dfs(questions, 0);
    }

    private long dfs(int[][] questions, int i) {
        if (i == questions.length - 1) {
            return questions[i][0];
        }

        if (i > questions.length - 1) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        long take = questions[i][0] + dfs(questions, i + questions[i][1] + 1);
        long notTake = dfs(questions, i + 1);
        return memo[i] = Math.max(take, notTake);
    }
}
