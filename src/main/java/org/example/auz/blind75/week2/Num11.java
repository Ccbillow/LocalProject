package org.example.auz.blind75.week2;

import java.util.Arrays;

/**
 * Contains Duplicate
 * <p>
 * https://leetcode.com/problems/contains-duplicate/description/
 * <p>
 * *  * Time Complexity: O(n log(n))
 * *  * Space Complexity: O(log(n))
 */
public class Num11 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }
}
