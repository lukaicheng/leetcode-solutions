package com.github.lucifer.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, 
 * write a function that will return true if the ransom note can be constructed from the magazines ; 
 * otherwise, it will return false.
 * <p>Each letter in the magazine string can only be used once in your ransom note.
 * <p><strong>Note:</strong>
 * <p>You may assume that both strings contain only lowercase letters.
 * <pre>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * </pre>
 * 
 * @author Lucifer
 */
public class RansomNoteSolution {

    public static void main(String[] args) {
        RansomNoteSolution solution = new RansomNoteSolution();
        System.out.println(solution.canConstruct("a", "b"));
        System.out.println(solution.canConstruct("aa", "ab"));
        System.out.println(solution.canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.isEmpty()) {
            return true;
        }
        if (magazine == null || magazine.isEmpty()) {
            return false;
        }
        Map<Character, Integer> noteMap = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            if (noteMap.containsKey(c)) {
                noteMap.put(c, noteMap.get(c) + 1);
            } else {
                noteMap.put(c, 1);
            }
        }
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            if (magazineMap.containsKey(c)) {
                magazineMap.put(c, magazineMap.get(c) + 1);
            } else {
                magazineMap.put(c, 1);
            }
        }
        for (Entry<Character, Integer> entry : noteMap.entrySet()) {
            char key = entry.getKey();
            if (!magazineMap.containsKey(key)) {
                return false;
            }
            if (magazineMap.get(key) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
