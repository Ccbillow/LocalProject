package org.example.interview.tree;

public class MaxValue {

    public static int getMaxValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getMaxValue(root.getLeft());
        int right = getMaxValue(root.getRight());
        return Math.max(root.getValue(), Math.max(left, right));
    }

    public static void main(String[] args) {
        System.out.println(getMaxValue(TreeNode.init()));
    }
}
