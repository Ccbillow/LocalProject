package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 654. Maximum Binary Tree
 * https://leetcode.com/problems/maximum-binary-tree/description/
 */
public class Num_654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }

        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            if (max < nums[i]) {
                index = i;
                max = nums[i];
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = build(nums, low, index - 1);
        root.right = build(nums, index + 1, high);
        return root;
    }
}
