package org.example.auz.practice.greedy;

/**
 * 55. jump-game
 * https://leetcode.cn/problems/jump-game/description/
 */
public class Num_55_1 {

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);

            if (max <= i) {
                return false;
            }
        }
        return max >= nums.length - 1;
    }
}
