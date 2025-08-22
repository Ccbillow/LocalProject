package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 1325. Delete Leaves With a Given Value
 * https://leetcode.com/problems/delete-leaves-with-a-given-value/
 *
 */
public class Num_1325 {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}
