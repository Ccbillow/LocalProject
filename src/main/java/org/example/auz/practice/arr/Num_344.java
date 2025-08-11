package org.example.auz.practice.arr;

/**
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/description/
 */
public class Num_344 {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
