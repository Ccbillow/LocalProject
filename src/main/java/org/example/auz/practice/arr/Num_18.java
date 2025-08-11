package org.example.auz.practice.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * https://leetcode.com/problems/4sum/description/
 */
public class Num_18 {

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
        return nSumTarget(nums, 4, 0, target);
    }

    private List<List<Integer>> nSumTarget(int[] nums, int n, int start, long target) {
        List<List<Integer>> res = new ArrayList<>();
        if (n > 2) {
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> nSumList = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> nSum : nSumList) {
                    ArrayList<Integer> tmp = new ArrayList<>(nSum);
                    tmp.add(nums[i]);
                    res.add(tmp);
                }

                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        } else {
            int left = start;
            int right = nums.length - 1;
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
        }
        return res;
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> threeSumList = threeSum(nums, i + 1, target - nums[i]);
            for (List<Integer> threeSum : threeSumList) {
                ArrayList<Integer> tmp = new ArrayList<>(threeSum);
                tmp.add(nums[i]);
                res.add(tmp);
            }

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    private List<List<Integer>> threeSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = start; i < nums.length; i++) {
            List<List<Integer>> twoSumList = twoSumList(nums, i + 1, target - nums[i]);
            for (List<Integer> twoSum : twoSumList) {
                ArrayList<Integer> tmp = new ArrayList<>(twoSum);
                tmp.add(nums[i]);
                res.add(tmp);
            }

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    private List<List<Integer>> twoSumList(int[] nums, int start, int target) {
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
                    right++;
                }
            } else if (val < target) {
                left++;
                while (left < right && low == nums[left]) {
                    left++;
                }
            } else {
                right--;
                while (left < right && high == nums[right]) {
                    right++;
                }
            }
        }
        return res;
    }
}
