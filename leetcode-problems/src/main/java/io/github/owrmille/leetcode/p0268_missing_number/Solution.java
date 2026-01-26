package io.github.owrmille.leetcode.p0268_missing_number;

/*
- LeetCode 268: Missing Number
- Difficulty: easy
- Topics: 
Array
Hash Table
Math
Binary Search
Bit Manipulation
Sorting
- Approach: 
XOR cancels same values: a^a=0, 
so each index will cancel a corresponding value from the array
- Time: O(n)  Space: O(1) 
*/

class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= nums[i] ^ i;
        }
        return missing;
    }
}
