package org.example.auz.practice.arr;

/**
 * LeetCode 360 **Sort Transformed Array（有序转化数组）
 */
public class Num_360 {

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int i = 0;
        int j = nums.length - 1;
        int index = a >= 0 ? nums.length - 1 : 0;
        int[] res = new int[nums.length];
        while (i <= j) {
            int left = f(nums[i], a, b, c);
            int right = f(nums[j], a, b, c);

            if (a >= 0) {
                if (left > right) {
                    res[index] = left;
                    i++;
                } else {
                    res[index] = right;
                    j--;
                }
                index--;
            } else {
                if (left < right) {
                    res[index] = left;
                    i++;
                } else {
                    res[index] = right;
                    j--;
                }
                index++;
            }
        }
        return res;
    }

    private int f(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }

    public int[] sortTransformedArray2(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = a >= 0 ? nums.length - 1 : 0;
        while (left <= right) {
            int leftVal = f(nums[left], a, b, c);
            int rightVal = f(nums[right], a, b, c);

            if (a >= 0) {
                if (leftVal >= rightVal) {
                    res[index] = leftVal;
                    left++;
                } else {
                    res[index] = rightVal;
                    right--;
                }
                index--;
            } else {
                if (leftVal <= rightVal) {
                    res[index] = leftVal;
                    left++;
                } else {
                    res[index] = rightVal;
                    right--;
                }
                index++;
            }
        }
        return res;
    }

}
