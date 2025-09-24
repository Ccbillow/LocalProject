package org.example.auz.practice.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * 2155. all-divisions-with-the-highest-score-of-a-binary-array
 * https://leetcode.cn/problems/all-divisions-with-the-highest-score-of-a-binary-array/description/
 */
public class Num_2155 {

    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int one = 0;
        for (int num : nums) {
            if (num == 1) one++;
        }

        int zero = 0;
        int max = one;

        res.add(0);

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] == 0) {
                zero++;
            } else if (nums[i - 1] == 1) {
                one--;
            }

            if (zero + one > max) {
                max = zero + one;
                res.clear();
                res.add(i);
            } else if (zero + one == max) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Num_2155 test = new Num_2155();

        int[] arr = {0, 0, 0};
        test.maxScoreIndices(arr);
    }
}
