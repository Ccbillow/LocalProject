package org.example.auz.stringsort;

import java.util.Arrays;
import java.util.List;

/**
 * Find second largest string from a given sentence
 */
public class SecondLargeString {


    public static void main(String[] args) {
        String sentence = "Java is an object oriented programming language";
        String secondLargeString = findSecondLargeString(sentence);
        System.out.println(secondLargeString);
    }

    public static String findSecondLargeString(String content) {
        if (content == null || content.isEmpty()) {
            return null;
        }

        String[] words = content.split(" ");
        Arrays.sort(words, (a, b) -> Integer.compare(b.length(), a.length()));
        List<String> list = Arrays.asList(words);

        if (list.size() == 1) {
            return "no second largest string";
        }

        return list.get(1);
    }
}
