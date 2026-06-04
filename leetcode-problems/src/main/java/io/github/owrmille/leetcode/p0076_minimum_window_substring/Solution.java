package io.github.owrmille.leetcode.p0076_minimum_window_substring;

/*
- LeetCode 76: Minimum Window Substring
- Difficulty: hard
- Topics:
Hash Table
String
Sliding Window
- Approach:
    similar to some other task (TODO: check out later)
- Time:
    O(n + m * k), where k is the number of distinct chars in t; worst case O(m * n)
- Space: O(m + n)
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {

    public boolean areAllLettersInWindow(
            Map<Character, Integer> letters,
            Map<Character, Integer> window) {

        // O(k); worst case O(n), where k is the number of distinct chars in t
        for (Map.Entry<Character, Integer> entry : letters.entrySet()) {
            char c = entry.getKey();
            if (window.getOrDefault(c, 0) < entry.getValue()) {
                return false;
            }
        }

        return true;
    }

    public String minWindow(String s, String t) {

        Map<Character, Integer> letters = new HashMap<>();

        // O(n)
        for (char c : t.toCharArray()) {
            letters.put(c, letters.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();

        String minSubStr = "";
        int minLen = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;

        // O(m)
        while (right <= s.length()) {

            // O(k); worst case O(n)
            if (areAllLettersInWindow(letters, window)) {

                if (right - left < minLen) {
                    minSubStr = s.substring(left, right);
                    minLen = minSubStr.length();
                }
                char c = s.charAt(left);
                window.put(c, window.getOrDefault(c, 1) - 1);
                left++;

            } else {
                if (right == s.length()) {
                    break;
                }
                char c = s.charAt(right);
                window.put(c,  window.getOrDefault(c, 0) + 1);
                right++;
            }
        }

        return minSubStr;
    }

    public String optimizedMinWindow(String s, String t) {

        Map<Character, Integer> letters = new HashMap<>();

        // O(n)
        for (char c : t.toCharArray()) {
            letters.put(c, letters.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();

        String minSubStr = "";
        int minLen = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;

        int need = letters.size();
        int have = 0;

        // O(m)
        while (right <= s.length()) {

            if (need == have) {

                if (right - left < minLen) {
                    minSubStr = s.substring(left, right);
                    minLen = minSubStr.length();
                }
                char c = s.charAt(left);

                if (letters.containsKey(c) && letters.get(c).equals(window.get(c))) {
                    have--;
                }

                window.put(c, window.getOrDefault(c, 1) - 1);

                left++;

            } else {

                if (right == s.length()) {
                    break;
                }

                char c = s.charAt(right);
                window.put(c,  window.getOrDefault(c, 0) + 1);

                if (letters.containsKey(c) && letters.get(c).equals(window.get(c))) {
                    have++;
                }

                right++;
            }
        }

        return minSubStr;
    }
}
