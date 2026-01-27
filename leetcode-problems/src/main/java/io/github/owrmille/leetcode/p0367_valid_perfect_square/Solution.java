package io.github.owrmille.leetcode.p0367_valid_perfect_square;

/*
- LeetCode 367: Valid Perfect Square
- Difficulty: easy
- Topics:
Math
Binary Search
- Approach:
important detail: used long, so I can use multiplication mid * mid, 
and not division num/mid (which doesn't work properly here because of rounding)
- Time: O(log num)  Space: O(1)
*/

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;

        long left = 1, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
