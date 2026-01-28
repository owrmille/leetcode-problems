package io.github.owrmille.leetcode.p0744_find_smallest_letter_greater_than_target;

/*
- LeetCode 744: Find Smallest Letter Greater Than Target
- Difficulty: easy
- Topics:
Array
Binary Search
Weekly Contest 62
- Approach:
F F F T T T T T T -> at some point values are bigger than target (T - true for condition letters[mid] > target).
we need to store the value that meets this condition, and cut right side, since we need to find the smallest suitable value
P.S.: be careful of:
    - what you return -> need to return a char, not an index
    - which part you cut after checking the condition
    - IMPORTANT: if there is no suitable letter, return the first one
- Time: O(log n) Space: O(1)
*/

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        int firstSmallest = 0;  // if there is nothing greater than target, this will be returned -> correct behaviour
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                firstSmallest = mid;
                right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }
        return letters[firstSmallest];
    }
}
