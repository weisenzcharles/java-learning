package org.charles.learning.algorithm;

public class PalindromeCheck {

    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        char[] chars = str.toCharArray();

        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"aba", "1221", " ", "112233221", "asa", "1b2b2b1"};
        for (String str : strings) {
            boolean palindrome = isPalindrome(str);
            System.out.println(str + " is " + palindrome);
        }
    }
}
