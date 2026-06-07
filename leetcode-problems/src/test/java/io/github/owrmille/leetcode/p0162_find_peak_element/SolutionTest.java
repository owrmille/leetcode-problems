package io.github.owrmille.leetcode.p0162_find_peak_element;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private static void assertReturnsPeak(int[] nums) {
        Solution s = new Solution();
        int peak = s.findPeakElement(nums);

        assertTrue(peak >= 0 && peak < nums.length);
        assertTrue(peak == 0 || nums[peak] > nums[peak - 1]);
        assertTrue(peak == nums.length - 1 || nums[peak] > nums[peak + 1]);
    }

    @Test
    void example1() {
        Solution s = new Solution();

        assertEquals(2, s.findPeakElement(new int[] {1, 2, 3, 1}));
    }

    @Test
    void example2WithMultiplePossiblePeaks() {
        assertReturnsPeak(new int[] {1, 2, 1, 3, 5, 6, 4});
    }

    @Test
    void singleElement() {
        Solution s = new Solution();

        assertEquals(0, s.findPeakElement(new int[] {5}));
    }

    @Test
    void strictlyIncreasing() {
        Solution s = new Solution();

        assertEquals(4, s.findPeakElement(new int[] {1, 2, 3, 4, 5}));
    }

    @Test
    void strictlyDecreasing() {
        Solution s = new Solution();

        assertEquals(0, s.findPeakElement(new int[] {5, 4, 3, 2, 1}));
    }

    @Test
    void singleIntegerMinValueIsPeak() {
        Solution s = new Solution();

        assertEquals(0, s.findPeakElement(new int[] {Integer.MIN_VALUE}));
    }

    @Test
    void integerMinValueAtLeftBoundary() {
        assertReturnsPeak(new int[] {Integer.MIN_VALUE, -10, -5});
    }

    @Test
    void integerMinValueAtRightBoundary() {
        assertReturnsPeak(new int[] {-5, -10, Integer.MIN_VALUE});
    }
}
