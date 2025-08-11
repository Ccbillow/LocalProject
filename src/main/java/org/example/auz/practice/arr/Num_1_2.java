package org.example.auz.practice.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Two Sum target
 */
public class Num_1_2 {

    public static List<List<Integer>> twoSumTarget(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0;
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
                while (left < right && low == nums[left]) {
                    left++;
                }
                left++;
            } else {
                while (left < right && high == nums[right]) {
                    right--;
                }
                right--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3, 3};
        System.out.println(twoSumTarget(arr, 4));
    }
}
