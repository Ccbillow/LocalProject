package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 1110. Delete Nodes And Return Forest
 * https://leetcode.com/problems/delete-nodes-and-return-forest/description/
 */
public class Num_1110 {

    Set<Integer> delSet = new HashSet<>();

    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return new LinkedList<>();
        }

        for (int i : to_delete) {
            delSet.add(i);
        }

        to_delete(root, true);
        return res;
    }

    private TreeNode to_delete(TreeNode root, boolean isRoot) {
        if (root == null) {
            return null;
        }

        boolean deleted = delSet.contains(root.val);
        if (isRoot && !deleted) {
            res.add(root);
        }

        root.left = to_delete(root.left, deleted);
        root.right = to_delete(root.right, deleted);
        return deleted ? null : root;
    }
}
