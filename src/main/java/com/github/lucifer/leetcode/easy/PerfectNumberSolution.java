package com.github.lucifer.leetcode.easy;

/**
 * We define the Perfect Number is a <strong>positive</strong> integer that is equal to the sum of all its <strong>positive</strong> divisors except itself.
 * <p>Now, given an <strong>integer</strong> n, write a function that returns true when it is a perfect number and false when it is not.
 * <p><strong>Example:</strong>
 * <pre>
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * </pre>
 * <p><strong>Note:</strong> The input number <strong>n</strong> will not exceed 100,000,000. (1e8)
 * 
 * @author Lucifer
 */
public class PerfectNumberSolution {

    public static void main(String[] args) {
        PerfectNumberSolution solution = new PerfectNumberSolution();
        System.out.println(solution.checkPerfectNumber(1));
        System.out.println(solution.checkPerfectNumber(28));
        System.out.println(solution.checkPerfectNumber0(1));
        System.out.println(solution.checkPerfectNumber0(28));
        for (int i = 1; i < 1000; i++) {
            if (solution.checkPerfectNumber0(i)) {
                System.out.println(i);
            }
        }
    }

    public boolean checkPerfectNumber(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        int i = 1;
        int end = num;
        int sum = 0;
        while (i < end) {
            if (num % i == 0) {
                end = num / i;
                if (end != num) {
                    sum = sum + i + end;
                } else {
                    sum = sum + i;
                }
            }
            i++;
        }
        return num == sum;
    }

    public boolean checkPerfectNumber0(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        int i = 2;
        int end = (int) Math.sqrt(num);
        int sum = 1;
        while (i <= end) {
            if (num % i == 0) {
                int divisor = num / i;
                if (divisor != i) {
                    sum = sum + i + divisor;
                } else {
                    sum = sum + divisor;
                }
            }
            i++;
        }
        return num == sum;
    }
}
