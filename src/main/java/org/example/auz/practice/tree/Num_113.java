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
        if (root == null) {
            return new ArrayList<>();
        }

        traverse(root, targetSum);
        return res;
    }

    private void traverse(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        path.addLast(root.val);

        if (root.left == null && root.right == null && root.val == targetSum) {
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }

        targetSum = targetSum - root.val;
        traverse(root.left, targetSum);
        traverse(root.right, targetSum);

        path.removeLast();
    }
}
