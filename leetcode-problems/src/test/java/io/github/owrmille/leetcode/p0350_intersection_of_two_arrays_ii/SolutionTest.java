package io.github.owrmille.leetcode.p0350_intersection_of_two_arrays_ii;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private static void assertArrayEqualsIgnoreOrder(int[] expected, int[] actual) {
        int[] expectedSorted = Arrays.copyOf(expected, expected.length);
        int[] actualSorted = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expectedSorted);
        Arrays.sort(actualSorted);
        assertArrayEquals(expectedSorted, actualSorted);
    }

    @Test
    void example1() {
        Solution s = new Solution();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        assertArrayEqualsIgnoreOrder(new int[] {2, 2}, s.intersect(nums1, nums2));
    }

    @Test
    void example2() {
        Solution s = new Solution();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        assertArrayEqualsIgnoreOrder(new int[] {4, 9}, s.intersect(nums1, nums2));
    }

    @Test
    void noIntersection() {
        Solution s = new Solution();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6};

        assertArrayEqualsIgnoreOrder(new int[] {}, s.intersect(nums1, nums2));
    }

    @Test
    void allDuplicates() {
        Solution s = new Solution();
        int[] nums1 = {2, 2, 2, 2};
        int[] nums2 = {2, 2};

        assertArrayEqualsIgnoreOrder(new int[] {2, 2}, s.intersect(nums1, nums2));
    }

    @Test
    void singleElementMatch() {
        Solution s = new Solution();
        int[] nums1 = {7};
        int[] nums2 = {7};

        assertArrayEqualsIgnoreOrder(new int[] {7}, s.intersect(nums1, nums2));
    }
}
