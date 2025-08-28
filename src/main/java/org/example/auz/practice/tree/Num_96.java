package org.example.auz.practice.tree;

/**
 * 96. Unique Binary Search Trees
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 */
public class Num_96 {

    int[] count;

    public int numTrees(int n) {
        count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        return helper(n);
    }

    private int helper(int n) {
        if (count[n] != 0) {
            return count[n];
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = res + helper(i - 1) * helper(n - i);
        }
        count[n] = res;
        return res;
    }
}
