package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 701. Insert into a Binary Search Tree
 */
public class Num_701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
