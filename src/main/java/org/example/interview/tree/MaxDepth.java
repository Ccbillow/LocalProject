package org.example.interview.tree;

public class MaxDepth {

    public static int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getMaxDepth(root.getLeft());
        int right = getMaxDepth(root.getRight());
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        System.out.println(getMaxDepth(TreeNode.init()));
    }
}
