package org.example.auz.practice.graph.bfs;

import org.example.auz.blind75.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 863. all-nodes-distance-k-in-binary-tree
 * https://leetcode.cn/problems/all-nodes-distance-k-in-binary-tree/description/?show=1
 */
public class Num_863 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        build(root, null, parent);


        List<Integer> res = new ArrayList<>();

        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(target);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            if (step == k) {
                for (TreeNode node : q) {
                    res.add(node.val);
                }
                return res;
            }

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.removeFirst();


                if (cur.left != null && !visited.contains(cur.left)) {
                    visited.add(cur.left);
                    q.addLast(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right)) {
                    visited.add(cur.right);
                    q.addLast(cur.right);
                }
                if (parent.get(cur) != null && ! visited.contains(parent.get(cur))) {
                    visited.add(parent.get(cur));
                    q.addLast(parent.get(cur));
                }
            }
            step++;
        }
        return res;
    }

    private void build(TreeNode root, TreeNode par, Map<TreeNode, TreeNode> parent) {
        if (root == null) {
            return;
        }

        parent.put(root, par);
        build(root.left, root, parent);
        build(root.right, root, parent);
    }
}
