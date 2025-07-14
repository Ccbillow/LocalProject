package org.example.interview.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。需要实现的函数twoSum需要返回这两个数的下标。
 */
public class TwoSum {

    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                return new int[]{map.get(arr[i]), i};
            }
            map.put(target - arr[i], i);
        }
        return new int[]{};
    }


    public static int[] twoSum1(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                return new int[]{map.get(arr[i]), i};
            }
            map.put(target - arr[i], i);
        }
        return new int[]{};
    }
}
