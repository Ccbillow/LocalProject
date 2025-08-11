package org.example.auz.practice.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/description/
 *
 */
public class Num_1_1 {
    static class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public static  int[] twoSum(int[] nums, int target) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new Pair(nums[i], i));
        }

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int val = nums[left] + nums[right];
            if (target == val) {
                int p = 0;
                int q = 0;
                for (int i = 0; i < list.size(); i++) {
                    if (p == 0 && list.get(i).key == nums[left]) {
                        p = list.get(i).value;
                    } else if (q == 0 && list.get(i).key == nums[right]) {
                        q = list.get(i).value;
                    }
                }
                return new int[]{p, q};
            } else if (val < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 5, 11};
        twoSum(arr, 10);
    }
}
