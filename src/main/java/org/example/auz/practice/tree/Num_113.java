package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 */
public class Num_113 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum);
        return res;
    }

    void traverse(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        path.addLast(root.val);

        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                res.add(new LinkedList<>(path));
            }
        }

        traverse(root.left, targetSum - root.val);
        traverse(root.right, targetSum - root.val);
        path.removeLast();
    }
}
