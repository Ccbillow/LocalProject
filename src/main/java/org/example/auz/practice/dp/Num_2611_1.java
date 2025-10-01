package org.example.auz.practice.dp;

/**
 * 2611. mice-and-cheese
 * https://leetcode.cn/problems/mice-and-cheese/description/?show=1
 */
public class Num_2611_1 {

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        return dfs(0, k, reward1, reward2);
    }

    private int dfs(int i, int k, int[] reward1, int[] reward2) {
        if (i >= reward1.length) {
            return 0;
        }
        if (k == 0) {
            int sum = 0;
            while (i < reward2.length) {
                sum = sum + reward2[i];
                i++;
            }
            return sum;
        }
        int take = reward1[i] + dfs(i + 1, k - 1, reward1, reward2);
        int notTake = reward2[i] + dfs(i + 1, k, reward1, reward2);
        return Math.max(take, notTake);
    }

}
