package io.github.owrmille.leetcode.p0035_search_insert_position;

/*
- LeetCode 35: Search Insert Position
- Difficulty: easy
- Topics: 
Array
Binary Search
- Approach:
looking for the smallest mid, s.t. nums[mid] >= target;
P.S.: in general can do opposite, just be careful what to return
- Time: O(log n)  Space: O(1)
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                // this case is about nums[mid] being too small -> target is definitely AFTER it
                // -> target is at least nums[mid + 1], i.e. "left" is a good marker for potential index
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // important:
        return left;
    }
}
