package org.example.interview.tree;

import java.util.List;

/**
 * 二叉树遍历
 */
public class Traverse {

    /**
     * 前序遍历
     * @param node
     */
    public static void preTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getValue());
        preTraverse(node.getLeft());
        preTraverse(node.getRight());
    }

    /**
     * 中序遍历
     * @param node
     */
    public static void inTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        inTraverse(node.getLeft());
        System.out.println(node.getValue());
        inTraverse(node.getRight());
    }

    /**
     * 后序遍历
     * @param node
     */
    public static void postTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        postTraverse(node.getLeft());
        postTraverse(node.getRight());
        System.out.println(node.getValue());
    }

    public static void main(String[] args) {
        preTraverse(TreeNode.init());
        inTraverse(TreeNode.init());
        postTraverse(TreeNode.init());
    }
}
