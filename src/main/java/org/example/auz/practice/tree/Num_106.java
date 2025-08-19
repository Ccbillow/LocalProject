package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 */
public class Num_106 {

    private Map<Integer, Integer> val2Index = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            val2Index.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        Integer index = val2Index.get(rootVal);
        int leftSize = index - inStart;
        root.left = build(inorder, inStart, index - 1,
                postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);
        return root;
    }
}
