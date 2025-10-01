package org.example.auz.practice.dp;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 337. house-robber-iii
 * https://leetcode.cn/problems/house-robber-iii/description/
 */
public class Num_337_1 {

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int notTake = rob(root.left) + rob(root.right);

        int take = root.val +
                (root.left == null ? 0 : rob(root.left.left) + rob(root.left.left.right)) +
                (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));

        return Math.max(take, notTake);
    }
}
