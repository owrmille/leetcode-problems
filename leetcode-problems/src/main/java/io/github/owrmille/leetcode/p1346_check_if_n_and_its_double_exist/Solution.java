package io.github.owrmille.leetcode.p1346_check_if_n_and_its_double_exist;

/*
- LeetCode 1346: Check If N and Its Double Exist
- Difficulty: easy
- Topics:
Array
Hash Table
Two Pointers
Binary Search
Sorting
Weekly Contest 175
- Approach:
for v1:
    - for each element - find an element that satisfies the main condition: el == 2*el.
    - since there is multiplication -> watch out for overflows

for v2:
    - key idea: we will use the cool property of set (lookup and add element is O(1))
    - special case: since only 0==2*0 we can process it separately (it is THE ONLY exception -> 
    don't try to change the approach for it, faster to process it alone and save time)
    - first we add all elements (except 0) to the set, then for each element we check if set contains double of this element
    - for 0: we just count how many times it appears, and return true, if more than once
- Time: O(n log n) for v1; O(n) for v2
- Space: O(1) for v1; O(n) for v2
*/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public boolean checkIfExistV1(int[] arr) {
        // O(n log n)
        Arrays.sort(arr);

        // O(n log n)
        for (int i = 0; i < arr.length; i++) {
            // to prevent overflow
            long t = 2L * arr[i];
            if (t < Integer.MIN_VALUE || t > Integer.MAX_VALUE) {
                continue;
            }

            // O(log n)
            int foundIdx = binarySearch(arr, (int)t);

            if (foundIdx != i && foundIdx >= 0) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfExistV2(int[] arr) {
        int cnt = 0;
        Set<Integer> nums = new HashSet<>();
        // O(n)
        for (int el : arr) {
            if (el == 0) {
                cnt++;
                continue;
            }
            // O(1)
            nums.add(el);
        }

        if (cnt > 1) return true;

        for (int el : nums) {
            long elLong = 2L * el;
            if (elLong > Integer.MAX_VALUE || elLong < Integer.MIN_VALUE) continue;
            // O(n)
            if (nums.contains((int)elLong)) return true;
        }

        return false;
    }

    public boolean checkIfExist(int[] arr) {
        return checkIfExistV2(arr);
    }
}
