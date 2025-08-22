package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 1123. Lowest Common Ancestor of Deepest Leaves
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/description/
 */
public class Num_1123_2 {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }

        Node node = traverse(root, 0);
        return node.node;
    }

    private Node traverse(TreeNode root, int depth) {
        if (root == null) {
            return new Node(null, 0);
        }

        Node left = traverse(root.left, depth + 1);
        Node right = traverse(root.right, depth + 1);

        if (left == right) {
            return new Node(root, depth);
        } else if (left.depth > right.depth) {
            return new Node(left.node, left.depth + 1);
        } else {
            return new Node(right.node, right.depth + 1);
        }
    }

    class Node {
        TreeNode node;
        int depth;

        public Node(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
