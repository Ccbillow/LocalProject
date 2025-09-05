package org.example.auz.practice.arr;

/**
 * 713. Subarray Product Less Than K
 * https://leetcode.com/problems/subarray-product-less-than-k/description/
 */
public class Num_713_1 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;

        int window = 1;

        int left = 0;
        int right = 0;
        while (right < nums.length) {
            window = window * nums[right];
            right++;

            while (left < right && window >= k) {
                window = window / nums[left];
                left++;
            }
            count = count + right - left;
        }
        return count;
    }

    /**
     * 300. longest-increasing-subsequence
     * https://leetcode.cn/problems/longest-increasing-subsequence/description/
     */
    public static class Num_300 {

        public int lengthOfLIS(int[] nums) {
            //todo
            return 0;
        }

    }
}
