package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 938. Range Sum of BST
 * https://leetcode.com/problems/range-sum-of-bst/description/
 */
public class Num_938_2 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else {
            return root.val
                    + rangeSumBST(root.left, low, high)
                    + rangeSumBST(root.right, low, high);
        }
    }

}
