package org.example.auz.practice.graph.dfs;

import org.example.auz.blind75.tool.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1261. 在受污染的二叉树中查找元素
 *
 * https://leetcode.cn/problems/find-elements-in-a-contaminated-binary-tree/description/
 *
 * dfs
 */
public class Num_1261_2 {

    Set<Integer> set = new HashSet<>();

    public Num_1261_2(TreeNode root) {
        build(root, 0);
    }

    private void build(TreeNode root, int val) {
        if (root == null) {
            return;
        }

        root.val = val;
        set.add(val);
        build(root.left, 2 * val + 1);
        build(root.right, 2 * val + 2);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
