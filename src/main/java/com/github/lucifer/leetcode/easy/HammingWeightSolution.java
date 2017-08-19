package com.github.lucifer.leetcode.easy;

/**
 * Write a function that takes <strong>an unsigned integer</strong> and returns the number of ’1' bits it has (also known as the Hamming weight).
 * <p>
 * For example, the 32-bit integer '11' has binary representation <code>00000000000000000000000000001011</code>, so the function should return 3.
 * @author Lucifer
 */
public class HammingWeightSolution {

    public static void main(String[] args) {
        HammingWeightSolution solution = new HammingWeightSolution();
        System.out.println(solution.hammingWeight(11));
        System.out.println(solution.hammingWeight(15));
        System.out.println(solution.hammingWeight0(2147483647));
    }

    public int hammingWeight(int n) {
        int weight = 0;
        while (n > 0) {
            weight += (n & 1);
            n = n >>> 1;
        }
        return weight;
    }

    public int hammingWeight0(int n) {
        int weight = 0;
        //For 2147483648 Integer.MAX_VALUE + 1 = Integer.MIN_VALUE
        while (n != 0) {
            weight += (n & 1);
            n = n >>> 1;
        }
        return weight;
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年8月18日 Lucifer creat
 */
