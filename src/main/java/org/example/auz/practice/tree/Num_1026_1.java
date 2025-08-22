package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 1026. Maximum Difference Between Node and Ancestor
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/
 *
 * time: O (n)
 * space: O (H)
 */
public class Num_1026_1 {

    public int maxAncestorDiff(TreeNode root) {
        return traverse(root, root.val, root.val);
    }

    int traverse(TreeNode root, int min, int max) {
        if (root == null) {
            return max - min;
        }

        min = Math.min(root.val, min);
        max = Math.max(root.val, max);

        int left = traverse(root.left, min, max);
        int right = traverse(root.right, min, max);

        return Math.max(left, right);
    }
}
