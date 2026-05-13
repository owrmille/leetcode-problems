package io.github.owrmille.leetcode.p0003_longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

/*
- LeetCode 3: Longest Substring Without Repeating Characters
- Difficulty: medium
- Topics:
Staff
Hash Table
String
Sliding Window
- Approach:
v1: since we need to "forget" the history before the duplicate from the past,
then I erase everything, and start from duplicate -> expensive

v2: 
- we have a sliding window, where left is a slow pointer, right - a fast one;
- we are moving the window, storing the max length;
- use map to store letter and their last seen position;
- to "forget" the history, we don't remove anything,
we just check if the past duplicate was before the window, or inside it;
- if inside -> move the window
- add/update last seen position for any letter anyway

- Time: worst case O(n^2) for v1; O(n) for v2   
- Space: O(min(n, alphabet size)) ≈ O(n) for both
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> letterIndexMap = new HashMap<>();

        int len = 0;
        int maxSubstrLen = 0;
        int i = 0;
        while (i < s.length()) {
            if (!letterIndexMap.containsKey(s.charAt(i))) {
                len++;
                if (len > maxSubstrLen) {
                    maxSubstrLen = len;
                }
            } else {
                i = letterIndexMap.get(s.charAt(i)) + 1;
                letterIndexMap.clear();
                len = 1;
            }

            letterIndexMap.put(s.charAt(i), i);
            i++;
        }

        return maxSubstrLen;
    }

    public int optimizedLengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();

        int maxLen = 0;
        int curLen;

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char letter = s.charAt(right);

            if (seen.containsKey(letter) && seen.get(letter) >= left) {
                left = seen.get(letter) + 1;
            }

            seen.put(letter, right);

            curLen = right - left + 1;
            maxLen = Math.max(curLen, maxLen);
        }

        return maxLen;
    }
}
