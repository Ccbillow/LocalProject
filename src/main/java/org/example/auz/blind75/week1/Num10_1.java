package org.example.auz.blind75.week1;

import org.example.auz.blind75.tool.TreeNode;

/**
 * Lowest Common Ancestor of a Binary Search Tree
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class Num10_1 {
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
