package io.github.owrmille.leetcode.p0374_guess_number_higher_or_lower;

/*
- LeetCode 374: Guess Number Higher or Lower
- Difficulty: easy
- Topics:
Binary Search
Interactive
- Approach:
be careful of boundaries and which conditions to check exactly
- Time: O(log n)  Space: O(1)
*/

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

// My example
class GuessGame {
    public static int pick = 0;

    public void setPick(int val) {
        pick = val;
    }
    public int guess(int num) {
        if (num == pick) return 0;
        else if (num < pick) return 1;
        else return -1;
    }
}

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) return mid;
            if (guess(mid) == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
