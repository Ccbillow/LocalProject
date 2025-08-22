package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 563. Binary Tree Tilt
 * https://leetcode.com/problems/binary-tree-tilt/description/
 */
public class Num_563 {

    int res = 0;
    public int findTilt(TreeNode root) {
        sum(root);
        return res;
    }

    int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = sum(root.left);
        int right = sum(root.right);

        res = res + Math.abs(left - right);

        return left + right + root.val;
    }
}
