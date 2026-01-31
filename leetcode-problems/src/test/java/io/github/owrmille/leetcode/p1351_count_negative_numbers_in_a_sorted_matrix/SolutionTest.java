package io.github.owrmille.leetcode.p1351_count_negative_numbers_in_a_sorted_matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void example1() {
        Solution s = new Solution();
        int[][] grid = {
            {4, 3, 2, -1},
            {3, 2, 1, -1},
            {1, 1, -1, -2},
            {-1, -1, -2, -3}
        };

        assertEquals(8, s.countNegatives(grid));
    }

    @Test
    void example2() {
        Solution s = new Solution();
        int[][] grid = {
            {3, 2},
            {1, 0}
        };

        assertEquals(0, s.countNegatives(grid));
    }

    @Test
    void example3() {
        Solution s = new Solution();
        int[][] grid = {
            {3,2},
            {-3,-3},
            {-3,-3},
            {-3,-3}
        };

        assertEquals(6, s.countNegatives(grid));
    }

    @Test
    void allNegative() {
        Solution s = new Solution();
        int[][] grid = {
            {-1, -2},
            {-3, -4}
        };

        assertEquals(4, s.countNegatives(grid));
    }

    @Test
    void singleRow() {
        Solution s = new Solution();
        int[][] grid = {
            {5, 1, 0, -1, -2}
        };

        assertEquals(2, s.countNegatives(grid));
    }

    @Test
    void singleColumn() {
        Solution s = new Solution();
        int[][] grid = {
            {2},
            {0},
            {-1},
            {-3}
        };

        assertEquals(2, s.countNegatives(grid));
    }
}
