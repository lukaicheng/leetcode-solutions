package com.github.lucifer.leetcode.easy;

import java.util.BitSet;
import java.util.HashMap;

/**
 * Given an integer array with even length,where different numbers in this array represent different kinds of candies.Each number means one candy of the corresponding kind. 
 * You need to distribute these candies equally in number to brother and sister.Return the maximum number of kinds of candies the sister could gain.
 * <p>
 * Example 1:
 * <pre>
 * Input: candies = [1,1,2,2,3,3]
 * Output: 3
 * Explanation:
 * There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 * Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too. 
 * The sister has three different kinds of candies.
 * </pre>
 * Example 2:
 * <pre>
 * Input: candies = [1,1,2,3]
 * Output: 2
 * Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1]. 
 * The sister has two different kinds of candies, the brother has only one kind of candies. 
 * </pre>
 * Note:
 * <ol>
 * <li>The length of the given array is in range [2, 10,000], and will be even.</li>
 * <li>The number in given array is in range [-100,000, 100,000].</li>
 * </ol>
 * 
 * @author Lucifer
 */
public class DistributeCandiesSolution {

    public static void main(String[] args) {
        int[] testCase1 = new int[] { 1, 1, 2, 2, 3, 3 };
        int[] testCase2 = new int[] { 1, 1, 2, 3 };
        DistributeCandiesSolution solution = new DistributeCandiesSolution();
        System.out.println(solution.distributeCandies(testCase1));
        System.out.println(solution.distributeCandies(testCase2));
        System.out.println(solution.distributeCandies0(testCase1));
        System.out.println(solution.distributeCandies0(testCase2));
        System.out.println(solution.distributeCandies00(testCase1));
        System.out.println(solution.distributeCandies00(testCase2));
    }

    public int distributeCandies(int[] candies) {
        int equal = candies.length >> 1;
        int sisterCurrentCandies = 0;
        HashMap<Integer, Integer> sister = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> brother = new HashMap<Integer, Integer>();
        for (int kind : candies) {
            if (sister.containsKey(kind)) {
                if (brother.containsKey(kind)) {
                    sister.put(kind, sister.get(kind) + 1);
                    sisterCurrentCandies++;
                } else {
                    brother.put(kind, 1);
                }
            } else {
                sister.put(kind, 1);
                sisterCurrentCandies++;
            }
        }
        if (sisterCurrentCandies <= equal) {
            return sister.size();
        }
        for (Integer value : sister.values()) {
            if (value == 1) {
                continue;
            }
            sisterCurrentCandies = sisterCurrentCandies - value + 1;
            if (sisterCurrentCandies <= equal) {
                return sister.size();
            }
        }
        int lack = sisterCurrentCandies - equal;
        return sister.size() - lack;
    }

    public int distributeCandies0(int[] candies) {
        int equal = candies.length >> 1;
        int sisterCurrentCandies = 0;
        int sisterDuplicateCandies = 0;
        HashMap<Integer, Integer> sister = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> brother = new HashMap<Integer, Integer>();
        for (int kind : candies) {
            if (sister.containsKey(kind)) {
                if (brother.containsKey(kind)) {
                    sister.put(kind, sister.get(kind) + 1);
                    sisterCurrentCandies++;
                    sisterDuplicateCandies++;
                } else {
                    brother.put(kind, 1);
                }
            } else {
                sister.put(kind, 1);
                sisterCurrentCandies++;
            }
        }
        int sisterNoDuplicate = sisterCurrentCandies - sisterDuplicateCandies;
        if (sisterNoDuplicate <= equal) {
            return sister.size();
        }
        int lack = sisterNoDuplicate - equal;
        return sister.size() - lack;
    }

    public int distributeCandies00(int[] candies) {
        int equal = candies.length >> 1;
        BitSet sister = new BitSet();
        BitSet brother = new BitSet();
        for (int kind : candies) {
            //The number in given array is in range [-100,000, 100,000],let number not be negative
            kind = kind + 100000;
            if (sister.get(kind)) {
                if (!brother.get(kind)) {
                    brother.set(kind);
                }
            } else {
                sister.set(kind);
            }
        }
        int card = sister.cardinality();
        return card <= equal ? card : equal;
    }
}
