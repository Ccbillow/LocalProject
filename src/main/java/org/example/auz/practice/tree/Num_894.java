package org.example.auz.practice.tree;

import com.sun.source.tree.Tree;
import org.example.auz.blind75.tool.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 894. All Possible Full Binary Trees
 * https://leetcode.com/problems/all-possible-full-binary-trees/description/
 */
public class Num_894 {

    Map<Integer, List<TreeNode>> memo = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new LinkedList<>();
        }

        return build(n);
    }

    private List<TreeNode> build(int n) {
        List<TreeNode> res = new LinkedList<>();
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        for (int left = 1; left < n; left = left + 2) {
            int right = n - 1 - left;
            for (TreeNode l : allPossibleFBT(left)) {
                for (TreeNode r : allPossibleFBT(right)) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        memo.put(n, res);
        return res;
    }
}
