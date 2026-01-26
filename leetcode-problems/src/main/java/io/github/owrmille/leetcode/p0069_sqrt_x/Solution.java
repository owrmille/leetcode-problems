package io.github.owrmille.leetcode.p0069_sqrt_x;

/*
- LeetCode 69: Sqrt(x)
- Difficulty: easy
- Topics: 
Math
Binary Search
- Approach:
looking for the biggest mid, s.t. mid**2 <= x;
P.S.: in general can do opposite, just be careful what to return
- Time: O(log x)  Space: O(1)
*/

class Solution {
    public int mySqrt(int x) {
        // process 0 (so no 0-division later) and 1
        if (x < 2) return x;
        // since 0 and 1 are already processed
        int left = 1;
        int right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // use division instead of multiplication to prevent overflow
            if (x / mid == mid) {
                return mid;
            }
            if (mid < x / mid) {
                left = mid + 1;
            } else {
                // this case is about mid**2 being too big
                right = mid - 1;
            }
        }
        return right;
    }
}
