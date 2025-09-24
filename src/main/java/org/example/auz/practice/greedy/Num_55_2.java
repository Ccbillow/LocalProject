package org.example.auz.practice.greedy;

/**
 * 55. jump-game
 * https://leetcode.cn/problems/jump-game/description/
 */
public class Num_55_2 {

    public boolean canJump(int[] nums) {
        int end = nums.length - 1;
        for (int i = end - 1; i >= 0; i--) {
            if (nums[i] + i >= end) end = i;
        }
        return end == 0;
    }

    public boolean canJump1(int[] nums) {
        int end = nums.length - 1;
        int idx = end;

        while (idx >= 0) {
            if (nums[idx] + idx >= end) {
                end = idx;
            }
            idx--;
        }

        return end == 0;
    }
}
