package org.example.auz.practice.arr;

/**
 * 1769. minimum-number-of-operations-to-move-all-balls-to-each-box
 * https://leetcode.cn/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/
 */
public class Num_1769 {

    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];

        char[] arr = boxes.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == '1') {
                    sum = sum + Math.abs(j - i);
                }
            }
            res[i] = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        Num_1769 test = new Num_1769();
        test.minOperations("110");
    }
}
