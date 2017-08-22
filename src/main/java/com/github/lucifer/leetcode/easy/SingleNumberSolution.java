package com.github.lucifer.leetcode.easy;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p><strong>Note:</strong>
 * <p>Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * @author Lucifer
 */
public class SingleNumberSolution {

    public static void main(String[] args) {
        SingleNumberSolution solution = new SingleNumberSolution();
        System.out.println(solution.singleNumber(new int[] { 1, 2, 3, 1, 3 }));
        System.out.println(solution.singleNumber(new int[] { 1 }));
        System.out.println(solution.singleNumber(new int[] { 4, 5, 7, 8, 5, 4, 8 }));
    }

    /**
     * 1. XOR运算符合交换律+结合律
     * 2. a ^ a = 0
     * 3. 0 ^ a = a
     * 
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            nums[i - 1] = nums[i] ^ nums[i - 1];
        }
        return nums[0];
    }

}
