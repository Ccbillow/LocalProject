package org.example.auz.practice.str;

/**
 * 209. Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/?show=1
 */
public class Num_209 {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;

        int val = 0;
        int min = Integer.MAX_VALUE;

        while (right < nums.length) {
            val = val + nums[right];
            right++;

            while (val >= target) {
                min = Math.min(min, right - left);

                val = val - nums[left];
                left++;
            }

//            if (target == val) {
//                min = Math.min(min, right - left);
//            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
