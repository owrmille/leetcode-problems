package io.github.owrmille.leetcode.p0162_find_peak_element;

/*
- LeetCode 162: Find Peak Element
- Difficulty: medium
- Topics:
Array
Binary Search
- Approach:
    important constraints: adjacent elems are not equal, elems outside of nums are -inf, we need to find ANY peak
    key idea: we shrink our area towards biggest neighbour
    (moving in an ascending direction guarantees that a peak exists on that side,
    because the array is finite and its outside boundary is negative infinity.)
- Time: O(log n)  Space: O(1)
*/

class Solution {

    // solution with a bug !!!
    public int findPeakElementWithBug(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int leftNeighbour = nums[left];
        int rightNeighbour = nums[right];

        int mid = 0;

        while (left <= right) {
            mid = left + (right-left)/2;

            if (mid - 1 == -1) {
                // bug! the element of nums could be Integer.MIN_VALUE as well, and then cannot compare with < or >
                leftNeighbour = Integer.MIN_VALUE;
            } else {
                leftNeighbour = nums[mid - 1];
            }

            if (mid + 1 == nums.length) {
                // bug! the element of nums could be Integer.MIN_VALUE as well, and then cannot compare with < or >
                rightNeighbour = Integer.MIN_VALUE;
            } else {
                rightNeighbour = nums[mid + 1];
            }

            if (nums[mid] > leftNeighbour &&
                    nums[mid] > rightNeighbour) {
                return mid;
            } else if (leftNeighbour > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return mid;
    }

    // good solution
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right-left)/2;

            boolean greaterThanLeft =
                    mid == 0 || nums[mid] > nums[mid-1];
            boolean greaterThanRight =
                    mid == nums.length - 1 || nums[mid] > nums[mid+1];

            if (greaterThanLeft && greaterThanRight) {
                return mid;
            } else if (mid > 0 && nums[mid-1] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
