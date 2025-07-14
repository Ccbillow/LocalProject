package org.example.auz.blind75.week2;

import java.math.BigInteger;

/**
 * Add Binary
 * <p>
 * https://leetcode.com/problems/add-binary/description/
 *
 */
public class Num7 {
    public String addBinary(String a, String b) {
        BigInteger a1 = new BigInteger(a, 2);
        BigInteger b1 = new BigInteger(b, 2);

        BigInteger integer = a1.add(b1);
        return integer.toString();
    }
}
