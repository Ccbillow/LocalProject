package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 938. Range Sum of BST
 * https://leetcode.com/problems/range-sum-of-bst/description/
 */
public class Num_938_1 {

    int res = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        traverse(root, low, high);
        return res;
    }

    private void traverse(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        if (low <= root.val && high >= root.val) {
            res = res + root.val;
        }

        if (root.val > high || root.val < low) {
            if (root.val > high) {
                traverse(root.left, low, high);
            }
            if (root.val < low) {
                traverse(root.right, low, high);
            }
        } else {
            traverse(root.left, low, high);
            traverse(root.right, low, high);
        }
    }
}
