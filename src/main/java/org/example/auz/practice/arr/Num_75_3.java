package org.example.auz.practice.arr;

/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/description/
 */
public class Num_75_3 {

    public void sortColors(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        int p2 = nums.length - 1;
        while (p1 <= p2) {
            if (nums[p1] == 0) {
                int tmp = nums[p0];
                nums[p0] = nums[p1];
                nums[p1] = tmp;
                p0++;
            } else if (nums[p1] == 2) {
                int tmp = nums[p2];
                nums[p2] = nums[p1];
                nums[p1] = tmp;
                p2--;
            } else if (nums[p1] == 1) {
                p1++;
            }

            if (p1 < p0) {
                p1 = p0;
            }
        }
    }



    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};

    }
}
