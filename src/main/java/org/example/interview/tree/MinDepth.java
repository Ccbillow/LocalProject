package org.example.interview.tree;

public class MinDepth {

    public static int getMinDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getMinDepth(root.getLeft());
        int right = getMinDepth(root.getRight());

        if (left == 0) {
            return right + 1;
        } else if (right == 0) {
            return left + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }
}
