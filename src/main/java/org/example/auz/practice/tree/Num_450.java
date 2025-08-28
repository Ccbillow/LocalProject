package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 450. Delete Node in a BST
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 */
public class Num_450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            TreeNode min = getMin(root);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
