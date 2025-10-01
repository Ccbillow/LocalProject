package org.example.auz.practice.dp;

import org.example.auz.blind75.tool.TreeNode;

/**
 * 337. house-robber-iii
 * https://leetcode.cn/problems/house-robber-iii/description/
 */
public class Num_337_3 {


    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    // 返回一个大小为 2 的数组 arr
    // arr[0] 表示不抢 root 的话，得到的最大钱数
    // arr[1] 表示抢 root 的话，得到的最大钱数
    int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // 抢，下家就不能抢了
        int take = root.val + left[0] + right[0];
        // 不抢，下家可抢可不抢，取决于收益大小
        int notTake = Math.max(left[0], left[1])
                + Math.max((right[0]), right[1]);

        return new int[]{notTake, take};
    }
}
