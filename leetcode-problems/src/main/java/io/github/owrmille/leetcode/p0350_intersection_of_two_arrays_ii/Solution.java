package io.github.owrmille.leetcode.p0350_intersection_of_two_arrays_ii;

/*
- LeetCode 350: Intersection of Two Arrays II
- Difficulty: 
- Topics:
Array
Hash Table
Two Pointers
Binary Search
Sorting
- Approach:
1. sort both arrs
2. scan both: if same elem, add and move; if one less, move inside its arr; if another less - otherwise
- Time: O(n log n + m log m) for v1; O(n + m) for v2
- Space: O(k), k - intersection size, for v1; O(min(n, m)) for v2

- Constraints (important to make algo optimal):
1 <= nums1.length, nums2.length <= 1000 (constraints for both)
0 <= nums1[i], nums2[i] <= 1000 (constraints for both)
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] intersectV1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);  // O(n log n)
        Arrays.sort(nums2);  // O(m log m)

        List<Integer> inter = new ArrayList<>();
        int i = 0, j = 0;

        // O(m + n)
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                inter.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        int[] res = new int[inter.size()];
        for (int k = 0; k < inter.size(); k++) {
            res[k] = inter.get(k);
        }
        return res;
    }

    public int[] intersectV2(int[] nums1, int[] nums2) {
        // time: O(n + m + k) -> O(n + m), since k<=min(n,m)
        // space: O(min(n, m))

        // since we know the constraints -> create frequency arr for elems from nums1
        int[] freqs = new int[1001];  // space: O(1)
        for (int el : nums1) freqs[el]++;  // time: O(n)

        int n = 0;

        // tmp may become bigger than needed
        int[] tmp = new int[Math.min(nums1.length, nums2.length)];  // space: O(min(n, m))
        for (int el : nums2) {  // time: O(m)
            if (freqs[el] > 0) {
                tmp[n++] = el;
                freqs[el]--;  // reduce counter: remove elems from nums2 that are the same as in nums1
            }
        }
        // copy n first elems of tmp to a new int[] array
        return Arrays.copyOf(tmp, n);  // time: O(k), k - intersection size
        // space: O(k)
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        return intersectV2(nums1, nums2);
    }
}
