package io.github.owrmille.leetcode.p1385_find_the_distance_value_between_two_arrays;

import java.util.Arrays;

/*
- LeetCode 1385: Find the Distance Value Between Two Arrays
- Difficulty: easy
- Topics:
Array
Two Pointers
Binary Search
Sorting
Biweekly Contest 22
- Approach:
    for v1:
    - brute force: loop through all possible combinations b/n two arrays;
    if condition is not met, go to another elem in the first array. 
    if nothing got broken till the end of the second array, count the current element of first array as legit

    for v2:
    - for each elem from arr1: 
        find one closest elem from arr2, and check if the distance between it and current elem from arr1 is <= d;
        if so -> skip this elem from arr1. if no -> count it.
- Time: O(n^2) for v1; O(m log m + n log m) for v2
- Space: O(1) for v1; O(1) for v2
*/

class Solution {
    public int findTheDistanceValueV1(int[] arr1, int[] arr2, int d) {
        int dist = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    break;
                }
                if (j == arr2.length - 1) dist++;
            }
        }
        return dist;
    }

    public int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int minDiffIdx = 0;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (Math.abs(arr[mid] - target) <= Math.abs(arr[minDiffIdx] - target)) {
                minDiffIdx = mid;
            }

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return minDiffIdx;
    }

    public int findTheDistanceValueV2(int[] arr1, int[] arr2, int d) {
        // O(m log m)
        Arrays.sort(arr2);

        int dist = 0;
        // O(n log m)
        for (int i = 0; i < arr1.length; i++) {
            // O(log m)
            int closest = binarySearch(arr2, arr1[i]);
            if (Math.abs(arr1[i] - arr2[closest]) <= d) continue;
            dist++;
        }

        return dist;
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        return findTheDistanceValueV2(arr1, arr2, d);
    }
}
