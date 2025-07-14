package org.example.auz.blind75.week1;

import java.util.Stack;

/**
 * Valid Parentheses
 * <p>
 * desc: https://leetcode.com/problems/valid-parentheses/description/
 */
public class Num2 {
    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if ('{' == aChar || '[' == aChar || '(' == aChar) {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character pop = stack.pop();
                if ((aChar == '}' && pop != '{') ||
                        (aChar == ']' && pop != '[') ||
                        (aChar == ')' && pop != '(')) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));      // true
        System.out.println(isValid("()[]{}"));  // true
        System.out.println(isValid("(]"));      // false
        System.out.println(isValid("([)]"));    // false
        System.out.println(isValid("{[]}"));    // true
    }
}
