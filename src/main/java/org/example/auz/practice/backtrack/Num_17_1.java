package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. letter-combinations-of-a-phone-number
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
 */
public class Num_17_1 {

    List<String> res = new ArrayList<>();

    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }

        char[] numbers = digits.toCharArray();
        dfs(numbers, 0);
        return res;
    }

    private void dfs(char[] numbers, int idx) {
        if (sb.length() == numbers.length) {
            res.add(sb.toString());
            return;
        }

        for (int i = idx; i < numbers.length; i++) {
            for (char c : getChar(numbers[i] - '0')) {
                sb.append(c);
                dfs(numbers, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    char[] getChar(int num) {
        if (num == 2) {
            return new char[]{'a', 'b', 'c'};
        } else if (num == 3) {
            return new char[]{'d', 'e', 'f'};
        } else if (num == 4) {
            return new char[]{'g', 'h', 'i'};
        } else if (num == 5) {
            return new char[]{'j', 'k', 'l'};
        } else if (num == 6) {
            return new char[]{'m', 'n', 'o'};
        } else if (num == 7) {
            return new char[]{'p', 'q', 'r', 's'};
        } else if (num == 8) {
            return new char[]{'t', 'u', 'v'};
        } else if (num == 9) {
            return new char[]{'w', 'x', 'y', 'z'};
        } else {
            throw new IllegalArgumentException("not support number");
        }
    }

    public static void main(String[] args) {
        Num_17_1 test = new Num_17_1();
        test.letterCombinations("23");
    }

}
