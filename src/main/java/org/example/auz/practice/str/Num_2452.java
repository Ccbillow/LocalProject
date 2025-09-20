package org.example.auz.practice.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 2452. words-within-two-edits-of-dictionary
 * https://leetcode.cn/problems/words-within-two-edits-of-dictionary/description/
 */
public class Num_2452 {

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for (String query : queries) {
            if (check(query, dictionary)) {
                res.add(query);
            }
        }
        return res;
    }

    private boolean check(String query, String[] dictionary) {
        for (String word : dictionary) {
            int diff = 0;

            for (int i = 0; i < query.length(); i++) {
                if (query.charAt(i) != word.charAt(i)) {
                    diff++;
                }

                if (diff > 2) {
                    break;
                }
            }

            if (diff <= 2) {
                return true;
            }
        }
        return false;
    }
}
