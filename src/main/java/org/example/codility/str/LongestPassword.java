package org.example.codility.str;

import java.util.Arrays;

/**
 * Input:  "test 5a2c d!dd 12ab3"
 * Output: 5   // "12ab3" 是唯一有效密码，长度为 5
 */
public class LongestPassword {

    public static int solution(String str) {
        String[] words = str.split(" ");
        int max = 0;

        for (String word : words) {
            if (!word.matches("[a-zA-Z0-9]+")) {
                continue;
            }

            int letters = 0;
            int digital = 0;
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) {
                    letters++;
                }
                if (Character.isDigit(c)) {
                    digital++;
                }
            }

            if (letters % 2 == 0 && digital % 2 == 1) {
                max = Math.max(max, word.length());
            }
        }

        return max;
    }

    public static int longest(String str) {
        String[] words = str.split(" ");
        int max = 0;
        for (String word : words) {
            if (!word.matches("[a-zA-Z0-9]+")) {
                continue;
            }

            int letter = 0;
            int digital = 0;
            for (char c : word.toCharArray()) {
                if (Character.isDigit(c)) {
                    digital++;
                }
                if (Character.isLetter(c)) {
                    letter++;
                }
            }

            if (letter % 2 == 0 && digital % 2 == 1) {
                max = Math.max(max, word.length());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String string = "test 5a2c d!dd 12ab3";
//        System.out.println(solution(string));
//        System.out.println(longest(string));

        System.out.println(lp(string));
    }

    public static int lp(String str) {
        String[] words = str.split(" ");

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].matches("[a-zA-Z0-9]+")) {
                continue;
            }

            String word = words[i];
            int digital = 0;
            int letter = 0;
            for (int j = 0; j < word.length(); j++) {
                if (Character.isLetter(word.charAt(j))) {
                    letter++;
                }
                if (Character.isDigit(word.charAt(j))) {
                    digital++;
                }
            }

            if (letter % 2 == 0 && digital % 2 == 1) {
                max = Math.max(max, word.length());
            }
        }
        return max;
    }
}
