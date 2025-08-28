package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 700. Search in a Binary Search Tree
 */
public class Num_700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
