package org.example.auz.practice.arr;

/**
 * LCR 181. 字符串中的单词反转
 * https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/description/?show=1
 */
public class LCR_181 {

    public static String reverseMessage(String message) {
        if (message == null || "".equals(message)) {
            return "";
        }

        String reverse = reverse(message.toCharArray());
        String[] split = reverse.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            if (s.isEmpty()) {
                continue;
            }
            sb.append(reverse(s.toCharArray())).append(" ");
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    private static String reverse(char[] chars) {
        if (chars == null || chars.length == 0) {
            return "";
        }

        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
//        String s = "the sky is blue";
        String s = " ";
//        String s = "  hello world!  ";
        System.out.println(reverseMessage(s));
    }
}
