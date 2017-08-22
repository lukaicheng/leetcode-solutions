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
        System.out.println(solution.missingNumber0(new int[] { 1, 0 }));
    }

    /**
     * 思路一：预期总和-实际总和=缺少的数
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectSum = (n + 1) * n / 2;
        int realSum = 0;
        for (int num : nums) {
            realSum += num;
        }
        return expectSum - realSum;
    }

    /**
     * 思路二 完整的数组，那么计算结果0^0^1^1....n^n = 0
     * 假设中间缺少一个数，根据交换律和结合律最终结果，由于索引数组不变，那么最终结果=0^i=i，i为对应缺少的数
     */
    public int missingNumber0(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ i ^ nums[i];
        }
        return result ^ nums.length;
    }
}
