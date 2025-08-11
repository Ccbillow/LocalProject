package org.example.auz.blind75.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 */
public class Num_105 {

    private Map<Integer, Integer> value2Index = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            value2Index.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int indexRoot = value2Index.get(rootVal);
        int leftSize = indexRoot - inStart;

        root.left = helper(preorder, preStart + 1, preStart + leftSize, inStart, indexRoot - 1);
        root.right = helper(preorder, preStart + leftSize + 1, preEnd, indexRoot + 1, inEnd);
        return root;
    }
}
