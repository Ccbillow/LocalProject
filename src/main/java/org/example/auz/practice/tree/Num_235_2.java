package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */
public class Num_235_2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            int val = root.val;

            if (p.val < val && q.val < val) {
                root = root.left;
            } else if (p.val > val && q.val > val) {
                root = root.right;
            } else {
                return root;
            }
        }
    }
}
