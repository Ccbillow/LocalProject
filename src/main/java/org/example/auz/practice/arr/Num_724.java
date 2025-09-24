package org.example.auz.practice.arr;

/**
 * 724. find-pivot-index
 * https://leetcode.cn/problems/find-pivot-index/description/
 */
public class Num_724 {

    public int pivotIndex(int[] nums) {
        long sum = 0;
        for (int n : nums) {
            sum += n;
        }

        long pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (pre == sum - nums[i] - pre) {
                return i;
            }
            pre = pre + nums[i];
        }
        return -1;
    }
}
