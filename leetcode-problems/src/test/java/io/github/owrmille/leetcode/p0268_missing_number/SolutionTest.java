package io.github.owrmille.leetcode.p0268_missing_number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void example1() {
        Solution s = new Solution();
        int[] nums = {3, 0, 1};

        assertEquals(2, s.missingNumber(nums));
    }

    @Test
    void example2() {
        Solution s = new Solution();
        int[] nums = {0, 1};

        assertEquals(2, s.missingNumber(nums));
    }

    @Test
    void example3() {
        Solution s = new Solution();
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};

        assertEquals(8, s.missingNumber(nums));
    }

    @Test
    void singleElementMissingZero() {
        Solution s = new Solution();
        int[] nums = {1};

        assertEquals(0, s.missingNumber(nums));
    }

    @Test
    void missingAtStart() {
        Solution s = new Solution();
        int[] nums = {1, 2, 3, 4};

        assertEquals(0, s.missingNumber(nums));
    }

    @Test
    void missingAtEnd() {
        Solution s = new Solution();
        int[] nums = {0, 1, 2, 3};

        assertEquals(4, s.missingNumber(nums));
    }
}
