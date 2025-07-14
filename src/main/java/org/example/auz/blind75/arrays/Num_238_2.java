package org.example.auz.blind75.arrays;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * time: O(n)
 * space: O(1)
 */
public class Num_238_2 {
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[i] = left;
            } else {
                left = left * nums[i - 1];
                res[i] = left;
            }
        }
        
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));

        int[] arr2 = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(arr2)));

    }
}
