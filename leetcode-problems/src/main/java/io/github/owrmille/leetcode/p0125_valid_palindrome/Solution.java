package io.github.owrmille.leetcode.p0125_valid_palindrome;

/*
- LeetCode 125: Valid Palindrome
- Difficulty: easy
- Topics:
Two Pointers
String
- Approach:
    move left, or right, or both at a time;
    general approach, but keep in mind: we need to cover cases without letters/digits
    (move left almost till the end, till left is close to right -> after that loop exits, and we return true)
- Time: O(n)  Space: O(1)
*/

class Solution {

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }
}
