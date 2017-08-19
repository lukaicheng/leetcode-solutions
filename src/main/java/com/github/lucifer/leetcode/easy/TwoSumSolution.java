package com.github.lucifer.leetcode.easy;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * <p>
 * Example:
 * <p>
 * <code>Given nums = [2, 7, 11, 15], target = 9,</code><br>
 * <code>Because nums[0] + nums[1] = 2 + 7 = 9,</code><br>
 * <code>return [0, 1].</code>
 * 
 * @author Lucifer
 *
 */
public class TwoSumSolution {

	public static void main(String[] args) {
		TwoSumSolution solution = new TwoSumSolution();
		int nums[] = { -3, 4, 3, 90 };
		int target = 0;
		// System.out.println(solution.twoSum(nums, target));
		int[] result = solution.twoSum00(nums, target);
		System.out.println("[" + result[0] + "," + result[1] + "]");
	}

	/**
	 * 思路一
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0, length = nums.length; i < length; i++) {
			if (nums[i] > target) {
				continue;
			}
			int j = i + 1;
			int tmpTarget = target - nums[i];
			while (j < length) {
				if (nums[j] == tmpTarget) {
					result[0] = i;
					result[1] = j;
					break;
				}
				j++;
			}
		}
		return result;
	}

	/**
	 * 思路二
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum0(int[] nums, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0, length = nums.length; i < length; i++) {
			if (nums[i] > target) {
				continue;
			}
			int remain = target - nums[i];
			if (map.containsKey(remain)) {
				int j = map.get(remain);
				if (i < j) {
					result[0] = i;
					result[1] = j;
				} else {
					result[0] = j;
					result[1] = i;
				}
				break;
			} else {
				map.put(nums[i], i);
			}
		}
		return result;
	}

	public int[] twoSum00(int[] nums, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0, length = nums.length; i < length; i++) {
			int remain = target - nums[i];
			if (map.containsKey(remain)) {
				int j = map.get(remain);
				if (i < j) {
					result[0] = i;
					result[1] = j;
				} else {
					result[0] = j;
					result[1] = i;
				}
				break;
			} else {
				map.put(nums[i], i);
			}
		}
		return result;
	}
	
}
