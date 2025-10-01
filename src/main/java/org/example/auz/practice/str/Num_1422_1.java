package org.example.auz.practice.str;

/**
 * 1422. maximum-score-after-splitting-a-string
 * https://leetcode.cn/problems/maximum-score-after-splitting-a-string/description/?envType=study-plan-v2&envId=primers-list
 */
public class Num_1422_1 {

    public int maxScore(String s) {
        int res = 0;

        for (int i = 1; i <= s.length() - 1; i++) {
            int left = score(s, i, true);
            int right = score(s, i, false);
            res = Math.max(res, left + right);
        }
        return res;
    }

    private int score(String s, int idx, boolean left) {
        int score = 0;
        if (left) {
            for (int i = 0; i < idx; i++) {
                if (s.charAt(i) == '0') {
                    score++;
                }
            }
        } else {
            for (int i = idx; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    score++;
                }
            }
        }

        return score;
    }

    public static void main(String[] args) {
        Num_1422_1 test = new Num_1422_1();
        test.maxScore("00");
    }
}
