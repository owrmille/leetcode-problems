package io.github.owrmille.leetcode.p1337_the_k_weakest_rows_in_a_matrix;

import java.util.Arrays;
import java.util.Comparator;

/*
- LeetCode 1337: The K Weakest Rows in a Matrix
- Difficulty: easy
- Topics:
Array
Binary Search
Sorting
Heap (Priority Queue)
Matrix
Weekly Contest 174
- Approach:
    v1 (not optimal):
    - traverse through each row and find the index of the last soldier via binary search -> use it then to find number of soldiers
    - sort indices using custom comparator (which will use numbers of soldiers as a sort key)
- Time: O(m log n) + O(m log m) for v1;
- Space: O(m) for v1;
*/

class Solution {
    public int binarySearch(int[] row) {
        int left = 0, right = row.length - 1;
        int lastSoldier = -1;  // if there is no soldiers -> it returns -1 as idx of the first soldier (non-existed), and outside we add 1 to get number of soldiers
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (row[mid] == 1) {
                lastSoldier = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return lastSoldier;
    }

    public int[] kWeakestRowsV1(int[][] mat, int k) {
        int numRows = mat.length;

        // space: O(m)
        Integer[] indices = new Integer[numRows];
        // runtime: O(m)
        for (int i = 0; i < numRows; i++) {
            indices[i] = i;
        }

        // space: O(m)
        int[] rows = new int[numRows];
        int numSoldiers;
        // runtime: O(m log n)
        for (int i = 0; i < numRows; i++) {
            // binary search - runtime: O(log n)
            numSoldiers = binarySearch(mat[i]) + 1;
            rows[i] = numSoldiers;
        }

        // runtime: O(m log m)
        Arrays.sort(indices, Comparator.comparingInt(i -> rows[i]));
        // for each elem i in indices we use row[i] as a sort key

        // space: O(k)
        int[] rangeOfK = new int[k];
        // runtime: O(k)
        for (int i = 0; i < k; i++) {
            rangeOfK[i] = indices[i];
        }

        // Total runtime: O(m log n) + O(m log m)
        // Total space: O(m)

        return rangeOfK; 
    }

    // TODO: implement optimal version with constraint (using buckets) and without (using heap)

    public int[] kWeakestRows(int[][] mat, int k) {
        return kWeakestRowsV1(mat, k);
    }
}
