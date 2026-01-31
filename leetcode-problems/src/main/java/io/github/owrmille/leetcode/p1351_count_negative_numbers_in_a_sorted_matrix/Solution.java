package io.github.owrmille.leetcode.p1351_count_negative_numbers_in_a_sorted_matrix;

/*
- LeetCode 1351: Count Negative Numbers in a Sorted Matrix
- Difficulty: easy
- Topics:
Array
Binary Search
Matrix
Weekly Contest 176
- Approach:
    for v1:
        - key idea: for each row -> find a first appearance of a negative number in a row with binary search
    for v2:
        - key idea 1: since elements are ordered in both dimensions: if the current elem is negative, then elements after it(on the right, or under it) can only be negative
        - key idea 2: start from right top element and walk through, moving only to the left or down ->
        so the complexity is O(m + n), cause there are at most m steps down and n steps up, and nothing more
        - pay attention to how you count elements (for example, when j=-1, and all elems in a row are negative -> count it gracefully)
- Time: O(m log n) for v1; O(m + n) for v2
- Space: O(1) for v1; O(1) for v2
*/

class Solution {
    // F F F T
    // F F F T
    // F F T T
    // T T T T 
    public int binarySearch(int[] arr) {
        int l = 0, r = arr.length - 1; 
        int firstNegative = arr.length;  // so that if there is no negative elems, we will return the length of the row, and later: cnt += n - n -> cnt += 0;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (arr[mid] < 0) {
                firstNegative = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return firstNegative;
    }

    public int countNegativesV1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int cnt = 0;
        // O(m log n)
        for (int i = 0; i < m; i++) {
            // O(log n)
            cnt += n - binarySearch(grid[i]);  // binarySearch returns here the index of the first appearance of the negative number in the row
        }

        return cnt;
    }

    //      j=n-1
    // F F F |T|  i=0
    // F F F |T|
    // F F T |T|
    // T T T |T|
    public int countNegativesV2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int cnt = 0;

        // right top element
        int i = 0;
        int j = n - 1;

        // stop when it's out of boundaries (EXCEPT for j: my solution accepts -1, since it means that all elems in the row are negative)
        while (i < m && j >= -1) {
            // if all elems in the row are negative, or if the current elem is NOT negative -> we need to count elems in a row, and move to the next row
            if (j == -1 || grid[i][j] >= 0 ) {
                cnt += n - 1 - j;
                i++;  // move down
                if (j == -1) j++;  // move index back to the legit position
            } else j--;  // if negative, move left -> to bigger elems -> to find the first negative appearance in the current row
        }

        // we move either to the left or down -> m + n steps at most -> complexity O(m + n)

        return cnt;
    }

    public int countNegatives(int[][] grid) {
        return countNegativesV2(grid);
    }
}
