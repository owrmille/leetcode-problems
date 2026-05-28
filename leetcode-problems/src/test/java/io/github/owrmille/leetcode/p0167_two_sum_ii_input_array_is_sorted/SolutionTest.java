package io.github.owrmille.leetcode.p0167_two_sum_ii_input_array_is_sorted;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void example1() {
        Solution s = new Solution();

        assertArrayEquals(new int[] {1, 2}, s.twoSum(new int[] {2, 7, 11, 15}, 9));
    }

    @Test
    void example2() {
        Solution s = new Solution();

        assertArrayEquals(new int[] {1, 3}, s.twoSum(new int[] {2, 3, 4}, 6));
    }

    @Test
    void example3() {
        Solution s = new Solution();

        assertArrayEquals(new int[] {1, 2}, s.twoSum(new int[] {-1, 0}, -1));
    }

    @Test
    void usesDuplicateValues() {
        Solution s = new Solution();

        assertArrayEquals(new int[] {2, 3}, s.twoSum(new int[] {1, 2, 2, 4}, 4));
    }

    @Test
    void usesFirstAndLastValues() {
        Solution s = new Solution();

        assertArrayEquals(new int[] {1, 5}, s.twoSum(new int[] {-5, -2, 0, 3, 9}, 4));
    }

    @Test
    void usesValuesInMiddle() {
        Solution s = new Solution();

        assertArrayEquals(new int[] {3, 4}, s.twoSum(new int[] {-10, -3, 1, 6, 8, 20}, 7));
    }
}
