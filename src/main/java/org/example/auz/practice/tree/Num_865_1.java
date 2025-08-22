package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.LinkedList;

/**
 * 865. Smallest Subtree with all the Deepest Nodes
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/
 */
public class Num_865_1 {


    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        if (left == right) {
            return root;
        } else if (left > right) {
            return subtreeWithAllDeepest(root.left);
        } else {
            return subtreeWithAllDeepest(root.right);
        }
    }

    int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);
        return 1 + Math.max(left, right);
    }

}
