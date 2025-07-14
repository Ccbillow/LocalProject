package org.example.auz.blind75.week2;

/**
 * Maximum Subarray
 * <p>
 * https://leetcode.com/problems/maximum-subarray/description/
 * <p>
 * *  * Time Complexity: O(n)
 * *  * Space Complexity: O(1)
 */
public class Num12 {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (currSum < 0) {
                currSum = 0;
            }

            currSum = currSum + nums[i];
            max = Math.max(max, currSum);
        }
        return max;
    }
}
