package org.example.auz.blind75.week1;

import org.example.auz.blind75.tool.TreeNode;

/**
 * Lowest Common Ancestor of a Binary Search Tree
 * <p>
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class Num10_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val = root.val;
        if (p.val < val && q.val < val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > val && q.val > val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

}
