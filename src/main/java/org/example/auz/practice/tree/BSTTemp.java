package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

public class BSTTemp {

    public boolean traverse(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        if (root.val < target) {
            traverse(root.right, target);
        } else {
            traverse(root.left, target);
        }
        return false;
    }
}
