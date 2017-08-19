package com.github.lucifer.leetcode.easy;

import java.util.BitSet;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Given two integers <code>x</code> and <code>y</code>, calculate the Hamming distance.
 * <p>
 * Note:
 * <p>
 * 0 ≤ x, y < 2^31.
 * <p>
 * Example:
 * <pre>
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ?   ?
 * The above arrows point to positions where the corresponding bits are different.
 * </pre>
 * 
 * @author Lucifer
 */
public class HammingDistanceSolution {

    public static void main(String[] args) {
        HammingDistanceSolution solution = new HammingDistanceSolution();
        System.out.println(solution.hammingDistance0(1, 4));
        System.out.println(solution.hammingDistance0(3, 1));
    }

    public int hammingDistance(int x, int y) {
        char[] xArray = Integer.toBinaryString(x).toCharArray();
        BitSet bsX = new BitSet();
        int indexX = xArray.length;
        for (char c : xArray) {
            if (c == '1') {
                bsX.set(indexX);
            }
            indexX--;
        }
        char[] yArray = Integer.toBinaryString(y).toCharArray();
        BitSet bsY = new BitSet();
        int indexY = yArray.length;
        for (char c : yArray) {
            if (c == '1') {
                bsY.set(indexY);
            }
            indexY--;
        }
        bsX.xor(bsY);
        return bsX.cardinality();
    }

    public int hammingDistance0(int x, int y) {
        int z = x ^ y;
        int result = 0;
        while (z > 0) {
            if ((z & 1) == 1) {
                result++;
            }
            z = z >> 1;
        }
        return result;
    }

}
