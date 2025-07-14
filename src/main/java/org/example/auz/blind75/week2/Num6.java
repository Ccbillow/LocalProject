package org.example.auz.blind75.week2;

import org.example.interview.linked.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Majority Element
 * <p>
 * https://leetcode.com/problems/majority-element/description/
 *
 *  * Time Complexity: O(n)
 *  * Space Complexity: O(n)
 */
public class Num6 {
    public int majorityElement(int[] nums) {
        int res = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            int value = (int) entry.getValue();
            if (max < value) {
                max = value;
                res = (int) entry.getKey();
            }
        }
        return res;
    }
}
