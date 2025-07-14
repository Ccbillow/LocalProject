package org.example.codility.stackqueue;

import java.util.Stack;

public class BalancedBrackets {

    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c=='{' || c=='['){
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(solution("{[()()]}"));
        System.out.println(solution("([)()]"));

        System.out.println();
        System.out.println(bracket("{[()()]}"));
        System.out.println(bracket("([)()]"));
    }

    public static boolean bracket(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if ('(' == c || '{' == c || '[' == c) {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character tmp = stack.pop();
                    if (('(' == tmp && ')' != c)
                            || ('{' == tmp && '}' != c)
                            || ('[' == tmp && ']' != c)) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
