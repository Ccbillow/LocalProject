package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 889. Construct Binary Tree from Preorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
 */
public class Num_889 {
    private Map<Integer, Integer> val2Index = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            val2Index.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int leftRootVal = preorder[preStart + 1];
        int index = val2Index.get(leftRootVal);
        int leftSize = index - postStart + 1;

        root.left = build(preorder, preStart + 1, preStart + leftSize, postorder, postStart, index);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, postorder, index + 1, postEnd - 1);
        return root;
    }
}
