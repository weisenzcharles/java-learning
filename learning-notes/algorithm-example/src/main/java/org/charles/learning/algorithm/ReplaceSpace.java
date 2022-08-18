package org.charles.learning.algorithm;

/**
 * 剑指 Offer 05. 替换空格。
 */
public class ReplaceSpace {
    public static void main(String[] args) {

        String str = "We are happy.";
        System.out.println(replaceSpace(str));
    }

    public static String replaceSpace(String str) {
        char[] chars = new char[str.length() * 3];
        int size = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            } else {
                chars[size++] = str.charAt(i);
            }
        }
        return new String(chars, 0, size);
    }
}
