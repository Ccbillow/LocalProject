package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1161. Maximum Level Sum of a Binary Tree
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/
 */
public class Num_1161 {

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int max = Integer.MIN_VALUE;
        int depth = 0;
        int resDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            int count = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.removeFirst();

                count = count + cur.val;
                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
            }
            depth++;
            if (count > max) {
                max = count;
                resDepth = depth;
            }
        }
        return resDepth;
    }
}
