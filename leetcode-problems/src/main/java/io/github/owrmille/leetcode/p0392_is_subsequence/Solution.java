package io.github.owrmille.leetcode.p0392_is_subsequence;

/*
- LeetCode 392: Is Subsequence
- Difficulty: easy
- Topics:
Junior
Two Pointers
String
Dynamic Programming
- Approach:
    when letters match, move ptr in the substring (since the previous letters from it were found already)
- Time: O(n)  Space: O(1)
*/

class Solution {
    public boolean isSubsequence(String s, String t) {

        int subStrPtr = 0;
        int strPtr = 0;

        while (subStrPtr < s.length()) {

            if (strPtr == t.length()) {
                return false;
            }

            if (t.charAt(strPtr) == s.charAt(subStrPtr)) {
                subStrPtr++;
            }

            strPtr++;
        }

        return true;
    }
}
