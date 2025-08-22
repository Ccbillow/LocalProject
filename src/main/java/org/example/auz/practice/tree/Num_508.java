package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 508. Most Frequent Subtree Sum
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 */
public class Num_508 {

    Map<Integer, Integer> sum2Count = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        traverse(root);

        int max = 0;
        for (Integer count : sum2Count.values()) {
            max = Math.max(max, count);
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sum2Count.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }


        int left = traverse(root.left);
        int right = traverse(root.right);

        int sum = left + right + root.val;
        sum2Count.put(sum, sum2Count.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
