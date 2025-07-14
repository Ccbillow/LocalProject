package org.example.auz.blind75.week1;

import org.example.auz.blind75.tool.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Balanced Binary Tree
 *
 * desc: https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Num11_2 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            int left = depth(node.left);
            int right = depth(node.right);
            if (Math.abs(left - right) > 1) {
                return false;
            }
        }
        return true;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left, right) + 1;
    }

}
