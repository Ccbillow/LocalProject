package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 112. path-sum
 * https://leetcode.cn/problems/path-sum/description/
 */
public class Num_112 {

    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        traverse(root, targetSum);
        return flag;
    }

    void traverse(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && root.val == target) {
            flag = true;
        }

        target = target - root.val;
        traverse(root.left, target);
        traverse(root.right, target);
    }
}
