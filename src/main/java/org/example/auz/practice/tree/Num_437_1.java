package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.HashMap;

/**
 * 437. Path Sum III
 * https://leetcode.com/problems/path-sum-iii/description/
 */
public class Num_437_1 {

    HashMap<Long, Integer> preSumCount = new HashMap<>();

    long pathSum = 0;
    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        preSumCount.put(0L, 1);
        traverse(root, targetSum);
        return res;
    }

    void traverse(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        pathSum = pathSum + root.val;
        res = res + preSumCount.getOrDefault(pathSum - targetSum, 0);
        preSumCount.put(pathSum, preSumCount.getOrDefault(pathSum, 0) + 1);

        traverse(root.left, targetSum);
        traverse(root.right, targetSum);

        preSumCount.put(pathSum, preSumCount.get(pathSum) - 1);
        pathSum = pathSum - root.val;
    }
}
