package org.example.auz.practice.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 402. Remove K Digits
 * https://leetcode.com/problems/remove-k-digits/description/?show=1
 */
public class Num_402 {

    public static String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && c <= stack.peekLast()) {
                stack.removeLast();
                k--;
            }

            stack.addLast(c);
        }

        while (k > 0 && !stack.isEmpty()) {
            stack.removeLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        removeKdigits("1432219", 3);
    }
}
