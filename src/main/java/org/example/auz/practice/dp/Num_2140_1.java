package org.example.auz.practice.dp;

/**
 * 2140. solving-questions-with-brainpower
 * https://leetcode.cn/problems/solving-questions-with-brainpower/description/?show=1
 */
public class Num_2140_1 {

    public long mostPoints(int[][] questions) {
        return dfs(questions, 0);
    }

    private int dfs(int[][] questions, int i) {
        if (i == questions.length - 1) {
            return questions[i][0];
        }

        if (i > questions.length - 1) {
            return 0;
        }

        int take = questions[i][0] + dfs(questions, i + questions[i][1] + 1);
        int notTake = dfs(questions, i + 1);
        return Math.max(take, notTake);
    }
}
