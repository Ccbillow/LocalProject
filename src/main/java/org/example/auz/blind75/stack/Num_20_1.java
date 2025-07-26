package org.example.auz.blind75.stack;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * time: O(n)
 * space: O(n)
 */
public class Num_20_1 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if ('(' == aChar || '[' == aChar || '{' == aChar) {
                stack.add(aChar);
            } else {
                Character tmp = stack.pop();
                if ((')' == aChar && tmp != '(')
                        || (']' == aChar && tmp != '[')
                        || ('}' == aChar && tmp != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
