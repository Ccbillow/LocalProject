package org.example.codility.str;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class PalindromicSentence {
    public static String solution(String S) {
        String[] words = S.split(" ");
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        Deque<String> deque = new ArrayDeque<>();
        String middle = null;

        // 用于避免重复使用组合
        Set<String> used = new HashSet<>();

        for (String word : wordSet) {
            String reversed = new StringBuilder(word).reverse().toString();

            // 回文词，可能放中间
            if (word.equals(reversed)) {
                if (middle == null) {
                    middle = word;
                }
                continue;
            }

            // 反转词也在列表中，且未使用该对
            if (wordSet.contains(reversed) && !used.contains(word) && !used.contains(reversed)) {
                deque.addFirst(word);
                deque.addLast(reversed);
                used.add(word);
                used.add(reversed);
            }
        }

        if (deque.isEmpty() && middle == null) {
            return "NO";
        }

        // 拼接结果
        StringBuilder result = new StringBuilder();
        for (String w : deque) {
            result.append(w).append(" ");
        }

        if (middle != null) {
            result.insert(result.length() / 2, middle + " ");
        }

        // 去掉最后一个空格
        return result.toString().trim();
    }

    // 测试
    public static void main(String[] args) {
        System.out.println(solution("live on time emit no evil")); // 可以输出原句或其他
        System.out.println(solution("abcc bc ac")); // 输出 NO
    }

}
