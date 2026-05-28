package io.github.owrmille.leetcode.p0167_two_sum_ii_input_array_is_sorted;

/*
- LeetCode 167: Two Sum II - Input Array Is Sorted
- Difficulty: medium
- Topics:
Array
Two Pointers
Binary Search
- Approach:
    key idea: move left from the smallest and right from the biggest (to the middle) ->
    that way we can control whether we increase or decrease total sum of two corresponding elems
- Time: O(n)  Space: O(1)
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left != right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[] { left+1, right+1 };
            }

            if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[0];
    }
}
