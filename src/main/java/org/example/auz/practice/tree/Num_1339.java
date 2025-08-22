package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 1339. Maximum Product of Splitted Binary Tree
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/
 *
 * time : O(n)
 * space : O(H)
 */
public class Num_1339 {

    long totalSum = 0;
    long max = 0;
    int mod = 1_000_000_007;

    // sum * (totalSum - sum)
    public int maxProduct(TreeNode root) {
        totalSum = sum(root);
        traverse(root);
        return (int) (max % mod);
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = traverse(root.left);
        int right = traverse(root.right);

        int sum = root.val + left + right;
        long product = sum * (totalSum - sum);
        max = Math.max(max, product);
        return sum;
    }

    int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.val + sum(root.left) + sum(root.right);
    }
}
