package io.github.owrmille.leetcode.p0704_binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void middleElement() {
        Solution s = new Solution();
        assertEquals(3, s.search(new int[]{-1,0,3,5,9,12}, 5));
    }

    @Test
    void absentElement() {
        Solution s = new Solution();
        assertEquals(-1, s.search(new int[]{-1,0,3,5,9,12}, 2));
    }

    @Test
    void firstElement() {
        Solution s = new Solution();
        assertEquals(0, s.search(new int[]{-1,0,3,5,9,12}, -1));
    }

    @Test
    void lastElement() {
        Solution s = new Solution();
        assertEquals(5, s.search(new int[]{-1,0,3,5,9,12}, 12));
    }

    @Test
    void singlePresent() {
        Solution s = new Solution();
        assertEquals(0, s.search(new int[]{5}, 5));
    }

    @Test
    void singleAbsent() {
        Solution s = new Solution();
        assertEquals(-1, s.search(new int[]{5}, 3));
    }

    @Test
    void largeArrayAbsent() {
        Solution s = new Solution();
        int[] nums = new int[10_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -9999 + i; // -9999 ... 0
        }
        assertEquals(-1, s.search(nums, 9999));
    }

    @Test
    void largeArrayPresent() {
        Solution s = new Solution();
        int[] nums = new int[10_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -9999 + i; // -9999 ... 0
        }
        assertEquals(1, s.search(nums, -9998));
    }
}

