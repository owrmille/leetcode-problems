package io.github.owrmille.leetcode.p0209_minimum_size_subarray_sum;

/*
- LeetCode 209: Minimum Size Subarray Sum
- Difficulty: medium
- Topics:
Array
Binary Search
Sliding Window
Prefix Sum
- Approach:
    ! Note for this task: a subarray is a *contiguous* non-empty sequence of elements within an array.
    use sliding window: move either left or right, depending on the condition sum>=target;
    move till either right is in the end, or sum is too big (so left can still move and discard extra nums)
- Time: O(n)  Space: O(1)
*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int numsLen = nums.length;

        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while (right < numsLen || sum >= target) {
            
            if (sum < target) {
                sum += nums[right];
                right++;
            } else {
                minLen = Math.min(minLen, right-left);
                sum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
