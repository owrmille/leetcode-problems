package io.github.owrmille.leetcode.p0278_first_bad_version;

/*
- LeetCode 278: First Bad Version
- Difficulty: easy
- Topics:
Binary Search
Interactive
- Approach:
save version that was definitely found to be bad -> in the end return it (it will store the first occurence) 
- Time: O(log n)  Space: O(1)
*/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
// My example:
class VersionControl {
    private static int firstBad = 5;
    private static int calls = 0;

    static void setFirstBad(int version) {
        firstBad = version;
        calls = 0;        
    }

    static boolean isBadVersion(int version) {
        calls++;
        return version >= firstBad;
    }
}

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int boundaryIdx = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                boundaryIdx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return boundaryIdx;
    }
}
