package org.example.auz.practice.tree;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. binary-tree-paths
 * https://leetcode.cn/problems/binary-tree-paths/description/
 */
public class Num_257 {

    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            path.add(root.val + "");
            res.add(String.join("->", path));
            path.remove(path.size() - 1);
            return;
        }

        path.add(root.val + "");

        dfs(root.left);
        dfs(root.right);

        path.remove(path.size() - 1);
    }
}
