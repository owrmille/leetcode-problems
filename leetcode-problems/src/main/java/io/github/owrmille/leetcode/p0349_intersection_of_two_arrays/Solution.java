package io.github.owrmille.leetcode.p0349_intersection_of_two_arrays;

/*
- LeetCode 349: Intersection of Two Arrays
- Difficulty: easy
- Topics:
Array
Hash Table
Two Pointers
Binary Search
Sorting
- Approach:
1. wrap arrays into sets -> so no duplicates
2. find intersection with help of .contains() -> don't store in array, since the size of result is not defined yet 
3. wrap set into array and return
note: can't retrieve el from set by index -> iterate in "for (int el : interSet)" loop and add idx i for iterating in array
- Time: O(m + n)  Space: O(m + n)
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int el : nums1) set1.add(el);

        Set<Integer> set2 = new HashSet<>();
        for (int el : nums2) set2.add(el);

        Set<Integer> interSet = new HashSet<>();
        for (int el : set1) {
            if (set2.contains(el)) interSet.add(el);
        }

        int[] interArr = new int[interSet.size()];
        int i = 0;
        for (int el : interSet) interArr[i++] = el;

        return interArr;
    }
}
