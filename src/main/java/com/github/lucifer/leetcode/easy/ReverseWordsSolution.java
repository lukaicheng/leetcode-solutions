package com.github.lucifer.leetcode.easy;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * <pre>
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * </pre>
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 * 
 * @author Lucifer
 */
public class ReverseWordsSolution {

    public static void main(String[] args) {
        ReverseWordsSolution solution = new ReverseWordsSolution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
        System.out.println(solution.reverseWords("Hello"));
    }

    public String reverseWords(String s) {
        if (s == null || s.trim().isEmpty()) {
            return s;
        }
        char[] array = s.toCharArray();
        int start = 0;
        int end = 0;
        boolean reverse = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                end = i;
                reverse = true;
            } else if (i == array.length - 1) {
                end = i + 1;
                reverse = true;
            }
            if (reverse) {
                int mid = (end + start) >>> 1;
                for (int j = start; j < mid; j++) {
                    swap(array, j, end - j - 1 + start);
                }
                start = end + 1;
                reverse = false;
            }
        }
        return new String(array);
    }

    private void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
