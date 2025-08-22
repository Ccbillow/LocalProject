package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 1026. Maximum Difference Between Node and Ancestor
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/
 */
public class Num_1026_3 {

    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        traverse(root, new LinkedList<>());
        return res;
    }

    void traverse(TreeNode root, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }

        path.addLast(root.val);

        if (root.left == null && root.right == null) {
            int max = Collections.max(path);
            int min = Collections.min(path);
            res = Math.max(res, max - min);
        }

        traverse(root.left, path);
        traverse(root.right, path);
        path.removeLast();
    }
}
