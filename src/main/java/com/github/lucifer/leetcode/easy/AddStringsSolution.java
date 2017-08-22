package com.github.lucifer.leetcode.easy;

/**
 * Given two non-negative integers <code>num1</code> and <code>num2</code> represented as string, return the sum of <code>num1</code> and <code>num2</code>.
 * 
 * <p><strong>Note:</strong>
 * <ol>
 * <li>The length of both num1 and num2 is < 5100.</li>
 * <li>Both num1 and num2 contains only digits 0-9.</li>
 * <li>Both num1 and num2 does not contain any leading zero.</li>
 * <li>You <strong>must not use any built-in BigInteger library</strong> or <strong>convert the inputs to integer</strong> directly.
 * </ol>
 * @author Lucifer
 */
public class AddStringsSolution {

    public static void main(String[] args) {
        AddStringsSolution solution = new AddStringsSolution();
        System.out.println(solution.addStrings("12", "27"));
        System.out.println(solution.addStrings("124", "27"));
        System.out.println(solution.addStrings("1234", "9527"));
    }

    public String addStrings(String num1, String num2) {
        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();
        int size = array1.length > array2.length ? array1.length : array2.length;
        int m = array1.length - 1;
        int n = array2.length - 1;
        char[] tmp = new char[] { 0, 0 };
        char[] result = new char[size + 1];
        for (int i = size - 1; i >= 0; i--) {
            char x;
            char y;
            if (m >= 0) {
                x = array1[m--];
            } else {
                x = '0';
            }
            if (n >= 0) {
                y = array2[n--];
            } else {
                y = '0';
            }
            tmp = sum(x, y, tmp[0]);
            result[i + 1] = tmp[1];
        }
        if (tmp[0] == '1') {
            result[0] = tmp[0];
            return new String(result);
        } else {
            return new String(result, 1, result.length - 1);
        }
    }

    private char[] sum(char x, char y, char up) {
        int upNum = (up == '1') ? 1 : 0;
        int sum = (x - '0') + (y - '0') + upNum;
        char[] result = new char[2];
        if (sum >= 10) {
            result[0] = '1';
            result[1] = (char) ((sum - 10) + '0');
        } else {
            result[0] = '0';
            result[1] = (char) (sum + '0');
        }
        return result;
    }
}
