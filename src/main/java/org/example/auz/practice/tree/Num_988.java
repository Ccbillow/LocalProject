package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.LinkedList;

/**
 * 988. Smallest String Starting From Leaf
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/description/
 */
public class Num_988 {

    StringBuilder sb = new StringBuilder();
    String res = null;

    public String smallestFromLeaf(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            sb.append((char) ('a' - root.val));
            sb.reverse();

            if (res == null || res.compareTo(sb.toString()) > 0) {
                res = sb.toString();
            }

            sb.reverse();
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        sb.append((char) ('a' - root.val));
        traverse(root.left);
        traverse(root.right);
        sb.deleteCharAt(sb.length() - 1);
    }
}
