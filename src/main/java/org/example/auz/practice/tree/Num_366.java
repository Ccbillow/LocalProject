package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 366. Find Leaves of Binary Tree
 */
public class Num_366 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        traverse(root);
        return res;
    }

    int traverse(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int left = traverse(root.left);
        int right = traverse(root.right);

        int height = Math.max(left, right) + 1;
        if (res.size() <= height) {
            res.add(new ArrayList<>());
        }
        res.get(height).add(root.val);
        return height;
    }
}
