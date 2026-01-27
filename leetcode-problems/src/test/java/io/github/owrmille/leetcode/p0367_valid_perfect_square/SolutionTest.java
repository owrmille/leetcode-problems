package io.github.owrmille.leetcode.p0367_valid_perfect_square;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void example1() {
        Solution s = new Solution();

        assertTrue(s.isPerfectSquare(16));
    }

    @Test
    void example2() {
        Solution s = new Solution();

        assertFalse(s.isPerfectSquare(14));
    }

    @Test
    void zeroAndOne() {
        Solution s = new Solution();

        assertTrue(s.isPerfectSquare(0));
        assertTrue(s.isPerfectSquare(1));
    }

    @Test
    void smallNonSquare() {
        Solution s = new Solution();

        assertFalse(s.isPerfectSquare(2));
        assertFalse(s.isPerfectSquare(3));
    }

    @Test
    void largePerfectSquare() {
        Solution s = new Solution();

        assertTrue(s.isPerfectSquare(2147395600)); // 46340^2
    }
}
