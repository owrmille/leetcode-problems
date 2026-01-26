package io.github.owrmille.leetcode.p0033_search_in_rotated_sorted_array;

/*
- LeetCode 33: Search in Rotated Sorted Array
- Difficulty: medium
- Topics:
Array
Binary Search
- Approach: 
0. if middle elem is already target, return it
1. find which half is sorted
2. check if target is in this half: if so, consider only this half. if no, consider another one
- Time: O(log n)  Space: O(1)
*/
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[left] <= nums[mid]) {  // check if the left half is sorted ("=" handles the 1-element case where left==mid)
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
