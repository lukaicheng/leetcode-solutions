package com.github.lucifer.leetcode.easy;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>For example, Given nums = <code>[0, 1, 3]</code> return <code>2</code>.
 * <p><strong>Note:</strong>
 * <p>Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * 
 * @author Lucifer
 */
public class MissingNumberSolution {

    public static void main(String[] args) {
        MissingNumberSolution solution = new MissingNumberSolution();
        System.out.println(solution.missingNumber(new int[] { 0, 1, 3 }));
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectSum = (n + 1) * n / 2;
        int realSum = 0;
        for (int num : nums) {
            realSum += num;
        }
        return expectSum - realSum;
    }
}
