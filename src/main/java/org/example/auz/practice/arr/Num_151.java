package org.example.auz.practice.arr;

/**
 * 151. Reverse Words in a String
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 */
public class Num_151 {

    public static String reverseWords(String s) {
        String reverse = reverse(s.toCharArray());

        StringBuilder sb = new StringBuilder();
        String[] words = reverse.split(" ");
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            sb.append(reverse(word.toCharArray())).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    private static String reverse(char[] chars) {
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "example   good a";

        System.out.println(reverseWords(s));
    }
}
