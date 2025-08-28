package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 */
public class Num_98 {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    boolean isValid(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValid(root.left, min, root)
                && isValid(root.right, root, max);
    }
}
