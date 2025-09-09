package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. gray-code
 *
 * https://leetcode.cn/problems/gray-code/description/
 */
public class Num_89 {

    List<Integer> res = new ArrayList<>();

    StringBuilder sb = new StringBuilder();


    public List<Integer> grayCode(int n) {
        dfs(n, new int[]{0, 1});
        return res;
    }

    private void dfs(int n, int[] nums) {
        if (sb.length() == n) {
            res.add(Integer.valueOf(sb.toString(), 2));
            return;
        }

        sb.append(nums[0]);
        dfs(n, new int[]{0, 1});
        sb.deleteCharAt(sb.length() - 1);

        sb.append(nums[1]);
        dfs(n, new int[]{1, 0});
        sb.deleteCharAt(sb.length() - 1);
    }
}
