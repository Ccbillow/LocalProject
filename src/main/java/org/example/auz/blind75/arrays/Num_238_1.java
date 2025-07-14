package org.example.auz.blind75.arrays;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * time: O(n^2)
 * space: O(1)
 */
public class Num_238_1 {
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            int tmp = 1;
            while (j < nums.length) {
                if (i == j) {
                    j++;
                    continue;
                }
                tmp = tmp * nums[j];
                j++;
            }
            res[i] = tmp;
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
