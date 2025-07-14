package org.example.codility.str;

public class Palindromes {

    public static boolean solution(String str) {
        str = str.toLowerCase().replaceAll("[^a-zA-z0-9]", "");
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("A man, a plan, a canal: Panama")); // true
        System.out.println(solution("race a car")); // false
        System.out.println(solution("madam")); // true

        System.out.println();

        System.out.println(palindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(palindrome("race a car")); // false
        System.out.println(palindrome("madam")); // true
    }


    public static boolean palindrome(String s) {
        String str = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}
