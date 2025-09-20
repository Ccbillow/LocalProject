package org.example.auz.practice.arr;

/**
 * 2938. separate-black-and-white-balls
 * https://leetcode.cn/problems/separate-black-and-white-balls/description/
 */
public class Num_2938 {

    public long minimumSteps(String s) {
        int cnt = 0;
        int res = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                cnt++;
            } else {
                res = res + cnt;
            }
        }
        return res;
    }
}
