package org.example.auz.practice.greedy;

/**
 * 45. jump-game-ii
 * https://leetcode.cn/problems/jump-game-ii/description/
 */
public class Num_45_2 {

    public int jump(int[] nums) {
        int steps = 0;

        int curMax = 0;
        int nxtMax = 0;

        for (int i = 0; i < nums.length; i++) {
            nxtMax = Math.max(nxtMax, nums[i] + i);

            if (i == curMax) {
                if (i == nums.length - 1) {
                    break;
                }

                steps++;
                curMax = nxtMax;
            }
        }

        return steps;
    }
}
