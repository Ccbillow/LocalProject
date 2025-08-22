package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 1026. Maximum Difference Between Node and Ancestor
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/
 */
public class Num_1026_2 {

    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        traverse(root, root.val, root.val);
        return res;
    }

    void traverse(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }

        res = Math.max(res, Math.max(Math.abs(root.val - min), Math.abs(root.val - max)));

        int newMin = Math.min(min, root.val);
        int newMax = Math.max(max, root.val);
        traverse(root.left, newMin, newMax);
        traverse(root.right, newMin, newMax);
    }
}
