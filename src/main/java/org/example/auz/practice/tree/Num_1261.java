package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1261. Find Elements in a Contaminated Binary Tree
 * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/description/
 */
public class Num_1261 {

    Set<Integer> set = new HashSet<>();

    public Num_1261(TreeNode root) {
        build(root, 0);
    }

    void build(TreeNode root, int val) {
        if (root == null) return;

        root.val = val;
        build(root.left, 2 * val + 1);
        build(root.right, 2 * val + 2);
        set.add(root.val);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
