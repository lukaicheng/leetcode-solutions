package com.github.lucifer.leetcode.easy;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p><strong>Example 1:</strong>
 * <pre>
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *   The maximum number of consecutive 1s is 3.
 * </pre>
 * <p><strong>Note:</strong>
 * <ol>
 * <li>The input array will only contain <code>0</code> and <code>1</code>.</li>
 * <li>The length of input array is a positive integer and will not exceed 10,000</li>
 * </ol> 
 * @author Lucifer
 */
public class MaxConsecutiveOnesSolution {

    public static void main(String[] args) {
        MaxConsecutiveOnesSolution solution = new MaxConsecutiveOnesSolution();
        System.out.println(solution.findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));
        System.out.println(
                solution.findMaxConsecutiveOnes(new int[] { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 }));
        System.out.println(solution
                .findMaxConsecutiveOnes(new int[] { 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 }));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int tmp = 0;
        for (int num : nums) {
            if (num == 1) {
                tmp++;
            } else {
                if (tmp >= max) {
                    max = tmp;
                }
                tmp = 0;
            }
        }
        if (tmp >= max) {
            max = tmp;
        }
        return max;
    }

}
