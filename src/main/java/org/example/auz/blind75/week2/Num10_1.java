package org.example.auz.blind75.week2;

import org.example.auz.blind75.tool.TreeNode;

/**
 * Maximum Depth of Binary Tree
 * <p>
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 *  *  * Time Complexity: O(n)
 *  *  * Space Complexity: O(h) [O(log n) ~ O(n)]
 */
public class Num10_1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
