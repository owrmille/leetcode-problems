package io.github.owrmille.leetcode.p0011_container_with_most_water;

/*
- LeetCode 11: Container With Most Water
- Difficulty: medium
- Topics:
Array
Two Pointers
Greedy
- Approach:
1. create two pinters that will go to the middle, and biggestArea variable to store the biggest val so far
2. whichever side is shorter should move (because the shortest side defines the area)
- Time: O(n)   Space: O(1)
*/

class Solution {

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int biggestArea = 0;
        int currentArea;
        while (l < r) {
            currentArea = (r - l) * Math.min(height[l], height[r]);
            biggestArea = Math.max(biggestArea, currentArea);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return biggestArea;
    }
}
