package io.github.owrmille.leetcode.p0001_two_sum;

import java.util.HashMap;
import java.util.Map;

/*
- LeetCode 1: Two Sum
- Difficulty: easy
- Topics:
Junior
Array
Hash Table
- Approach:
0. decide on DS (need cheap lookup + need to store connection between number and index for seen and past numbers -> map "seen")
// i.e. now we are at i = 3, nums[i] = 7. but complement is at i = 0, and we don't know its index
1. go through array and check if complement of cur number was already in seen -> return if yes
2. store cur number as a key; index of cur number i as value -> this is history
- Time: O(n)   Space: O(n)
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int complement = target - nums[i];

            if (seen.containsKey(complement)) {
                return new int[] {i, seen.get(complement)};
            }

            seen.put(current, i);
        }
        return new int[0];
    }
}
