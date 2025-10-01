package org.example.auz.practice.str;

/**
 * 1422. maximum-score-after-splitting-a-string
 * https://leetcode.cn/problems/maximum-score-after-splitting-a-string/description/?envType=study-plan-v2&envId=primers-list
 */
public class Num_1422_2 {

    public int maxScore(String s) {
        char[] arr = s.toCharArray();

        int[] preSum = new int[arr.length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= arr.length; i++) {
            preSum[i] = preSum[i - 1] + (arr[i - 1] - '0');
        }

        int res = 0;
        for (int i = 1; i <= s.length() - 1; i++) {
            int left = i - preSum[i];
            int right = preSum[s.length()] - preSum[i];
            res = Math.max(res, left + right);
        }
        return res;
    }


    public static void main(String[] args) {
        Num_1422_2 test = new Num_1422_2();
        test.maxScore("00");
    }
}
