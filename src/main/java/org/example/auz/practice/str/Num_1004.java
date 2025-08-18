package org.example.auz.practice.str;

/**
 * 1004. Max Consecutive Ones III
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/?show=1
 *
 */
public class Num_1004 {

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int res = 0;
        int window = 0;
        while (right < nums.length) {
            if (nums[right] == 1) {
                window++;
            }
            right++;

            while (right - left - window > k) {
                if (nums[left] == 1) {
                    window--;
                }
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
