package org.example.auz.practice.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * LCR 006. 两数之和 II - 输入有序数组
 * https://leetcode.cn/problems/kLl5u1/description/
 */
public class LCR_006 {

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int val = target - numbers[i];
            if (map.containsKey(val)) {
                return new int[]{map.get(val), i};
            }
            map.put(numbers[i], i);
        }
        return new int[]{};
    }

    public static int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int val = numbers[left] + numbers[right];
            if (val == target) {
                return new int[]{left, right};
            } else if (val < target) {
                left++;
            } else {
                right--;
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 4, 6, 10};
        twoSum(ints, 8);
    }
}
