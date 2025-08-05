package org.example.auz.blind75.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * time: O(n ^ 2)
 * space: O(h)
 */
public class Num_110_3 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();

            int left = high(root.left);
            int right = high(root.right);
            if (Math.abs(left - right) > 1) {
                return false;
            }

            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (node.right != null) {
                deque.addLast(node.right);
            }
        }
        return true;
    }

    private int high(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = high(root.left);
        int right = high(root.right);
        return Math.max(left, right) + 1;
    }
}
