package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 1448. Count Good Nodes in Binary Tree
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
 */
public class Num_1448 {

    int count = 0;

    public int goodNodes(TreeNode root) {
        traverse(root, root.val);
        return count;
    }

    private void traverse(TreeNode root, int max) {
        if (root == null) {
            return;
        }

        if (root.val >= max) {
            count++;
        }
        max = Math.max(root.val, max);

        traverse(root.left, max);
        traverse(root.right, max);
    }
}
