package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. Path Sum III
 * https://leetcode.com/problems/path-sum-iii/description/
 */
public class Num_437_3 {

    Map<Long, Integer> map = new HashMap<>();

    int res = 0;

    long sum = 0;

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        traverse(root, targetSum);
        return res;
    }

    void traverse(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        sum = sum + root.val;
        long need = sum - targetSum;
        if (map.containsKey(need)) {
            res = res + map.get(need);
        }

        if (!map.containsKey(sum)) {
            map.put(sum, 1);
        } else {
            map.put(sum, map.get(sum) + 1);
        }

        traverse(root.left, targetSum);
        traverse(root.right, targetSum);

        sum = sum - root.val;
        map.put(sum, map.get(sum) - 1);
    }
}
