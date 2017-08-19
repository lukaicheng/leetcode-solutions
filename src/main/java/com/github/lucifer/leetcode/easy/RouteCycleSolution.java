package com.github.lucifer.leetcode.easy;

/**
 * Initially, there is a Robot at position (0, 0). Given a sequence of its
 * moves, judge if this robot makes a circle, which means it moves back to
 * <strong>the original place</strong>.
 * <p>
 * The move sequence is represented by a string. And each move is represent by a
 * character. The valid robot moves are <code>R</code> (Right), <code>L</code>
 * (Left), <code>U</code> (Up) and <code>D</code> (down). The output should be
 * true or false representing whether the robot makes a circle.
 * <p>
 * Example 1:
 * <p>
 * <code>Input: "UD"</code><br>
 * <code>Output: true</code>
 * <p>
 * Example 2:
 * <p>
 * <code>Input: "LL"</code><br>
 * <code>Output: false</code>
 * 
 * @author Lucifer
 *
 */
public class RouteCycleSolution {

	public static void main(String[] args) {
		RouteCycleSolution solution = new RouteCycleSolution();
		System.out.println(solution.judgeCircle("UD"));
		System.out.println(solution.judgeCircle("LL"));
	}

	public boolean judgeCircle(String moves) {
		if (moves == null || moves.trim().isEmpty()) {
			return true;
		}
		int vertical = 0;
		int horizontal = 0;
		for (char c : moves.toCharArray()) {
			switch (c) {
			case 'R':
				horizontal++;
				continue;
			case 'L':
				horizontal--;
				continue;
			case 'U':
				vertical++;
				continue;
			case 'D':
				vertical--;
				continue;
			default:
				throw new IllegalArgumentException("Unexpected instruction!");
			}
		}
		return (vertical == 0) && (horizontal == 0);
	}
}
