package io.github.owrmille.leetcode.p0704_binary_search;

/*
- LeetCode 704: Binary Search
- Difficulty: easy
- Topics:
Array
Binary Search
- Approach:
regular binary search
- Time: O(log n)  Space: O(1)
*/

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
