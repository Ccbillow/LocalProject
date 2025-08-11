package org.example.auz.practice.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/description/
 *
 * time: O(n ^ 2)
 * space: O(n)
 */
public class Num_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        return threeSumTarget(nums, 0);
    }

    //O(n ^ 2)
    private static List<List<Integer>> threeSumTarget(int[] nums, int target) {
        // N logN
        Arrays.sort(nums);

        List<List<Integer>> threeSumList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // O(n)
            List<List<Integer>> twoSumList = twoSumTarget(nums, i + 1, target - nums[i]);
            for (List<Integer> twoSum : twoSumList) {
                ArrayList<Integer> tmp = new ArrayList<>(twoSum);
                tmp.add(nums[i]);
                threeSumList.add(tmp);
            }

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return threeSumList;
    }

    // O(n)
    private static List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        int left = start;
        int right = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (left < right) {
            int low = nums[left];
            int high = nums[right];
            int val = low + high;
            if (val == target) {
                res.add(List.of(low, high));

                while (left < right && low == nums[left]) {
                    left++;
                }
                while (left < right && high == nums[right]) {
                    right--;
                }
            } else if (val < target) {
                left++;
                while (left < right && low == nums[left]) {
                    left++;
                }
            } else {
                right--;
                while (left < right && high == nums[right]) {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }
}
