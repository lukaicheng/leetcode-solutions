package com.github.lucifer.leetcode.easy;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example:
 * <pre>
 * Given s = "hello", return "olleh".
 * </pre>
 * 
 * @author Lucifer
 *
 */
public class ReverseStringSolution {
	
	public static void main(String[] args){
		ReverseStringSolution solution = new ReverseStringSolution();
		System.out.println(solution.reverseString("hello"));
		System.out.println(solution.reverseString("java"));
	}

	public String reverseString(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		char[] array = s.toCharArray();
		int end = array.length >>> 1;
		for (int i = 0; i < end; i++) {
			swap(array, i, array.length - i - 1);
		}
		return new String(array);
	}

	private void swap(char[] array, int i, int j) {
		char tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
