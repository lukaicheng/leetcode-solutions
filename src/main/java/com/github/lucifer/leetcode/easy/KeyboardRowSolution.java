package com.github.lucifer.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a List of words, return the words that can be typed using letters of
 * alphabet on only one row's of American keyboard like the image below.
 * <p>
 * Example 1:
 * 
 * <pre>
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * </pre>
 * 
 * Note:
 * <ol>
 * <li>You may use one character in the keyboard more than once.</li>
 * <li>You may assume the input string will only contain letters of
 * alphabet.</li>
 * </ol>
 * 
 * @author Lucifer
 *
 */
public class KeyboardRowSolution {

	public static void main(String[] args) {
		String[] words = new String[] { "Hello", "Alaska", "Dad", "Peace" };
		KeyboardRowSolution solution = new KeyboardRowSolution();
		System.out.println(solution.findWords(words));
	}

	private static final String FISRT_LINE_CHARS = "qwertyuiopQWERTYUIOP";
	private static final String SECOND_LINE_CHARS = "asdfghjklASDFGHJKL";
	private static final String THIRD_LINE_CHARS = "zxcvbnmZXCVBNM";

	public String[] findWords(String[] words) {
		if (words == null || words.length == 0) {
			return new String[0];
		}
		List<String> list = new ArrayList<String>();
		for (String word : words) {
			char[] array = word.toCharArray();
			int line = 0;
			for (char c : array) {
				if (FISRT_LINE_CHARS.indexOf(c) != -1) {
					if (line == 0) {
						line = 1;
						continue;
					}
					if (line != 1) {
						line = 0;
						break;
					}
				}
				if (SECOND_LINE_CHARS.indexOf(c) != -1) {
					if (line == 0) {
						line = 2;
						continue;
					}
					if (line != 2) {
						line = 0;
						break;
					}
				}
				if (THIRD_LINE_CHARS.indexOf(c) != -1) {
					if (line == 0) {
						line = 3;
						continue;
					}
					if (line != 3) {
						line = 0;
						break;
					}
				}
			}
			if (line > 0) {
				list.add(word);
			}
		}
		return list.toArray(new String[list.size()]);
	}

}
