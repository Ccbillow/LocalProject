package org.example.auz.practice.arr;

import java.util.Arrays;

/**
 * 2578. split-with-minimum-sum
 * https://leetcode.cn/problems/split-with-minimum-sum/description/
 */
public class Num_2578 {

    public int splitNum(int num) {
        String s = String.valueOf(num);
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        int a = 0;
        int b = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (flag) {
                a = a * 10 + (arr[i] - '0');
                flag = false;
            } else {
                b = b * 10 + (arr[i] - '0');
                flag = true;
            }
        }
        return a + b;
    }

    public static void main(String[] args) {
        Num_2578 test = new Num_2578();
        System.out.println(test.splitNum(4325));
        System.out.println(test.splitNum(687));
    }
}
