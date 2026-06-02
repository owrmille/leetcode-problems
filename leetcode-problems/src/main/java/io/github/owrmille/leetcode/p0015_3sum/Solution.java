package io.github.owrmille.leetcode.p0015_3sum;

import java.util.*;

/*
- LeetCode 15: 3Sum
- Difficulty: medium
- Topics:
Array
Two Pointers
Sorting
- Approach:
    - sort
    - store in set for uniqueness
    - solve task 167 for each number in nums
- Time: O(n^2)  Space: O(n^2)
*/

class Solution {

    public boolean areDifferentNums(int a, int b, int c) {
        return a != b && a != c && b != c;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        // O(n log n)
        Arrays.sort(nums);

        // O(n)
        for (int i = 0; i < nums.length - 2; i++) {

            int target = - nums[i];

            int left = i;
            int right = nums.length - 1;

            // O(n)
            while (left < right) {

                if (nums[left] + nums[right] == target &&
                        areDifferentNums(i, left, right)) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);

                    // O(1)
                    set.add(triplet);
                }

                if (nums[left] + nums[right] > target || right == i) {
                    right--;
                } else  {
                    left++;
                }

            }
        }

        // O(n)
        for (List<Integer> triplet : set) {
            res.add(triplet);
        }

        return res;
    }
}