package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. Path Sum III
 * https://leetcode.com/problems/path-sum-iii/description/
 */
public class Num_437_2 {


    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        traverse(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return res;
    }

    void traverse(TreeNode root, long targetSum) {
        if (root == null) {
            return;
        }

        if (root.val == targetSum) {
            res++;
        }

        targetSum = targetSum - root.val;
        traverse(root.left, targetSum);
        traverse(root.right, targetSum);
    }


}
