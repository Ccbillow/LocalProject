package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382. Balance a Binary Search Tree
 *
 * https://leetcode.com/problems/balance-a-binary-search-tree/description/
 */
public class NUm_1382 {

    List<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        traverse(root);

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return build(arr, 0, arr.length - 1);
    }

    private TreeNode build(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = build(arr, start, mid - 1);
        root.right = build(arr, mid + 1, end);
        return root;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }
}
