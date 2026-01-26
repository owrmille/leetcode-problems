package io.github.owrmille.leetcode.p0035_search_insert_position;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void example1() {
        Solution s = new Solution();
        int[] nums = {1, 3, 5, 6};
        int target = 5;

        assertEquals(2, s.searchInsert(nums, target));
    }

    @Test
    void example2() {
        Solution s = new Solution();
        int[] nums = {1, 3, 5, 6};
        int target = 2;

        assertEquals(1, s.searchInsert(nums, target));
    }

    @Test
    void example3() {
        Solution s = new Solution();
        int[] nums = {1, 3, 5, 6};
        int target = 7;

        assertEquals(4, s.searchInsert(nums, target));
    }

    @Test
    void example4() {
        Solution s = new Solution();
        int[] nums = {1, 3, 5, 6};
        int target = 0;

        assertEquals(0, s.searchInsert(nums, target));
    }

    @Test
    void singleElementExactMatch() {
        Solution s = new Solution();
        int[] nums = {10};
        int target = 10;

        assertEquals(0, s.searchInsert(nums, target));
    }

    @Test
    void singleElementInsertAfter() {
        Solution s = new Solution();
        int[] nums = {10};
        int target = 11;

        assertEquals(1, s.searchInsert(nums, target));
    }
}
