package com.github.lucifer.leetcode.easy;

/**
 * You are given two arrays (without duplicates) <code>nums1</code> and <code>nums2</code> where <code>nums1</code>’s elements are subset of <code>nums2</code>. 
 * Find all the next greater numbers for <code>nums1</code>'s elements in the corresponding places of <code>nums2</code>.
 * <p>
 * The Next Greater Number of a number x in <code>nums1</code> is the first greater number to its right in <code>nums2</code>. 
 * If it does not exist, output -1 for this number.
 * <p>
 * Example 1:
 * <pre>
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 *   For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 *   For number 1 in the first array, the next greater number for it in the second array is 3.
 *   For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * </pre>
 * Example 2:
 * <pre>
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 *   For number 2 in the first array, the next greater number for it in the second array is 3.
 *   For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * </pre>
 * Note:
 * <ol>
 * <li>All elements in nums1 and nums2 are unique.</li>
 * <li>The length of both nums1 and nums2 would not exceed 1000.</li>
 * </ol>
 * @author Lucifer
 */
public class NextGreaterElementSolution {

    public static void main(String[] args) {
        NextGreaterElementSolution solution = new NextGreaterElementSolution();
        int[] nums1 = new int[] { 4, 1, 2 };
        int[] nums2 = new int[] { 1, 3, 4, 2 };
        System.out.println(solution.nextGreaterElement(nums1, nums2));
        nums1 = new int[] { 2, 4 };
        nums2 = new int[] { 1, 2, 3, 4 };
        System.out.println(solution.nextGreaterElement(nums1, nums2));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            boolean found = false;
            int nextGreaterElement = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (found) {
                    if (nums2[j] > nums1[i]) {
                        nextGreaterElement = nums2[j];
                        break;
                    }
                } else {
                    if (nums2[j] == nums1[i]) {
                        found = true;
                    }
                }
            }
            result[i] = nextGreaterElement;
        }
        return result;
    }

}
