package org.example.auz.practice.arr;

/**
 * 2270. number-of-ways-to-split-array
 * https://leetcode.cn/problems/number-of-ways-to-split-array/description/
 */
public class Num_2270_2 {

    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int n : nums) sum += n;

        int res = 0;
        long cur = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            cur = cur + nums[i];
            if (cur >= sum - cur) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Num_2270_2 test = new Num_2270_2();

        int[] arr = {10, 4, -8, 7};
        System.out.println(test.waysToSplitArray(arr));
    }
}
