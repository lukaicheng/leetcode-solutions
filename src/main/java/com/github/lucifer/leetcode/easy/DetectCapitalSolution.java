package com.github.lucifer.leetcode.easy;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * <p>We define the usage of capitals in a word to be right when one of the following cases holds:
 * <ol>
 * <li>All letters in this word are capitals, like "USA".</li>
 * <li>All letters in this word are not capitals, like "leetcode".</li>
 * <li>Only the first letter in this word is capital if it has more than one letter, like "Google".</li>
 * </ol>
 * <p>Otherwise, we define that this word doesn't use capitals in a right way.
 * <p><strong>Example 1:</strong>
 * <pre>
 * Input: "USA"
 * Output: True
 * </pre>
 * <p><strong>Example 2:</strong>
 * <pre>
 * Input: "FlaG"
 * Output: False
 * </pre>
 * <p><strong>Note:</strong>The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 * @author Lucifer
 */
public class DetectCapitalSolution {

    public static void main(String[] args) {
        DetectCapitalSolution solution = new DetectCapitalSolution();
        System.out.println(solution.detectCapitalUse("USA"));
        System.out.println(solution.detectCapitalUse("FlaG"));
        System.out.println(solution.detectCapitalUse("F"));
        System.out.println(solution.detectCapitalUse("a"));
        System.out.println(solution.detectCapitalUse("Fa"));
        System.out.println(solution.detectCapitalUse("FA"));
        System.out.println(solution.detectCapitalUse("fa"));
        System.out.println(solution.detectCapitalUse("fA"));
    }

    /**
     * status:
     * <ul>
     * <li>1 - 开头小写+后续小写</li>
     * <li>2 - 开头大写+后续小写</li>
     * <li>3 - 开头大写+后续大写</li>
     * </ul>
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        char[] letters = word.toCharArray();
        if (letters.length == 1) {
            return true;
        }
        boolean first = isUpperCase(letters[0]);
        boolean second = isUpperCase(letters[1]);
        int status = 0;
        if (first) {
            if (second) {
                status = 3;
            } else {
                status = 2;
            }
        } else {
            if (second) {
                return false;
            } else {
                status = 1;
            }
        }
        for (int i = 2; i < letters.length; i++) {
            boolean upper = isUpperCase(letters[i]);
            if (upper) {
                if (status == 1 || status == 2) {
                    return false;
                }
            } else {
                if (status == 3) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isUpperCase(char c) {
        if (c >= 'a' && c <= 'z') {
            return false;
        } else if (c >= 'A' && c <= 'Z') {
            return true;
        } else {
            throw new IllegalArgumentException("Unexpected letter : " + c);
        }
    }

}
