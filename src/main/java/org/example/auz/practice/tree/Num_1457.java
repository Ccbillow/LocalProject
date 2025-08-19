package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 1457. Pseudo-Palindromic Paths in a Binary Tree
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/description/
 */
public class Num_1457 {

    int res = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public int pseudoPalindromicPaths (TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);

            if (check(map)) {
                res++;
            }

            map.put(root.val, map.get(root.val) - 1);
            return;
        }

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        traverse(root.left);
        traverse(root.right);
        map.put(root.val, map.get(root.val) - 1);
    }

    private boolean check(Map<Integer, Integer> map) {
        int odd = 0;
        for (Integer value : map.values()) {
            if (value % 2 == 1) {
                odd++;
            }
        }
        return odd <= 1;
    }
}
