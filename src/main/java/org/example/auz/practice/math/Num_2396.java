package org.example.auz.practice.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 2396. strictly-palindromic-number
 * https://leetcode.cn/problems/strictly-palindromic-number/description/
 */
public class Num_2396 {

    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            if (!palindromic(n, i)) {
                return false; 
            }
        }
        return true;
    }

    private boolean palindromic(int n, int i) {
        List<Integer> nums = new ArrayList<>();
        while (n > 0) {
            nums.add(n % i);
            n = n / i;
        }

        int left = 0, right = nums.size() - 1;
        while (left < right) {
            if (nums.get(left) != nums.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
