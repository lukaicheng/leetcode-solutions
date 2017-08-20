package com.github.lucifer.leetcode.easy;

/**
 * Given a positive integer, output its complement number. The complement
 * strategy is to flip the bits of its binary representation.
 * <p>
 * Note:
 * <ol>
 * <li>The given integer is guaranteed to fit within the range of a 32-bit
 * signed integer.</li>
 * <li>You could assume no leading zero bit in the integer’s binary
 * representation.</li>
 * </ol>
 * <p>
 * Example 1:
 * 
 * <pre>
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * </pre>
 * <p>
 * Example 2:
 * 
 * <pre>
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 * </pre>
 * 
 * @author Lucifer
 *
 */
public class NumberComplementSolution {

	public static void main(String[] args) {
		NumberComplementSolution solution = new NumberComplementSolution();
		System.out.println(solution.findComplement(5));
		System.out.println(solution.findComplement(1));
	}

	public int findComplement(int num) {
		char[] array = Integer.toBinaryString(num).toCharArray();
		for (int i = 0; i < array.length; i++) {
			char c = array[i];
			if (c == '1') {
				array[i] = '0';
			} else {
				array[i] = '1';
			}
		}
		return Integer.parseInt(new String(array), 2);
	}

	// public int findComplement0(int num) {
	// int count = 0;
	// int b = num;
	// while (b != 0) {
	// count++;
	// b = b >> 1;
	// }
	// System.out.println(count);
	// int a = 1;
	// for (int shift = 32 - count - 1; shift > 0; shift--) {
	// a = (a << 1) + 1;
	// }
	// System.out.println(Integer.toBinaryString(a).length());
	// for (int i = 0; i < count; i++) {
	// a = (a << 1);
	// }
	// System.out.println(Integer.toBinaryString(a).length());
	// System.out.println(Integer.toBinaryString(num | a));
	// System.out.println(Integer.toBinaryString(a));
	// return ~(num | a);
	// }
}
