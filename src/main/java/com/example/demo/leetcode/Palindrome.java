package com.example.demo.leetcode;

import java.util.Stack;

/**
 * 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Palindrome {
    public static boolean isPalindrome(int x) {
        boolean res = false;
        if (x == 0) {
            return true;
        }
        String s = String.valueOf(x);
        if (x > 0 && x % 10 > 0) {
            boolean isEvenLength = s.length() % 2 == 0;
            int compareLength = 0;
            if (isEvenLength) {
                compareLength = s.length() / 2;
            } else {
                compareLength = (s.length() - 1) / 2;
            }
            int j = s.length() - 1;
            int temp = x;
            for (int i = 0; i < compareLength; i++) {
                if (!((int)(x / Math.pow(10, j) % 10) == (int)(temp % 10))) {
                    return res;
                }
                temp = temp / 10;
                j--;
            }
            res = true;
        }
        return res;
    }

    public static boolean isPalindrome2(int x) {
        boolean res = false;
        if (x < 0) {
            return res;
        }
        int cur = 0;
        int num = x;
        while (num != 0) {
            cur = cur * 10 + num % 10;
            num = num / 10;
        }
        return cur == x;
    }

    public static void main(String[] args) {
        int x = 121;
        boolean palindrome = isPalindrome(x);
        System.out.println(palindrome);

        boolean palindrome2 = isPalindrome2(x);
        System.out.println(palindrome2);
    }
}
