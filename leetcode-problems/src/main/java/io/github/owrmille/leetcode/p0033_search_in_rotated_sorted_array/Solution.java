package io.github.owrmille.leetcode.p0033_search_in_rotated_sorted_array;

//
// LeetCode 33: Search in Rotated Sorted Array
// Difficulty: ?
// Topics: ?
// Approach: ?
// Time: ?  Space: ?
//
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) { 
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) { 
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    
}
