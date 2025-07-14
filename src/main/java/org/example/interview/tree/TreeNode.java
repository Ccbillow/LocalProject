package org.example.interview.tree;

public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private int value;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public static TreeNode init() {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        three.setRight(six);
        two.setLeft(four);
        two.setRight(five);
        root.setLeft(two);
        root.setRight(three);
        return root;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
