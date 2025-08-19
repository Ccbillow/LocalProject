package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * time: O(n)
 * space: O(n)
 */
public class Num_199_1 {

    int depth;
    LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> rightSideView(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        depth++;
        if (depth > res.size()) {
            res.addLast(root.val);
        }

        traverse(root.right);
        traverse(root.left);
        depth--;
    }
}
