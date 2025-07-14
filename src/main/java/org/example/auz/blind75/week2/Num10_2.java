package org.example.auz.blind75.week2;

import org.example.auz.blind75.tool.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Maximum Depth of Binary Tree
 * <p>
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 *  *  * Time Complexity: O(n)
 *  *  * Space Complexity: O(n)
 */
public class Num10_2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
