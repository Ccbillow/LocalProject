package org.example.auz.blind75.week2;

import org.example.auz.blind75.tool.TreeNode;

/**
 * Diameter of Binary Tree
 * <p>
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 *
 *  *  * Time Complexity: O(n)
 *  *  * Space Complexity: O(n)
 */
public class Num8 {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);
        max = Math.max(left + right, max);

        return Math.max(left, right) + 1;
    }
}
