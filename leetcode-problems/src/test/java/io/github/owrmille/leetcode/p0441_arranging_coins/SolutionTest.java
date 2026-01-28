package io.github.owrmille.leetcode.p0441_arranging_coins;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void example1() {
        Solution s = new Solution();

        assertEquals(2, s.arrangeCoins(5));
    }

    @Test
    void example2() {
        Solution s = new Solution();

        assertEquals(3, s.arrangeCoins(8));
    }

    @Test
    void oneCoin() {
        Solution s = new Solution();

        assertEquals(1, s.arrangeCoins(1));
    }

    @Test
    void perfectTriangleNumber() {
        Solution s = new Solution();

        assertEquals(4, s.arrangeCoins(10));
    }

    @Test
    void largeInput() {
        Solution s = new Solution();

        assertEquals(65535, s.arrangeCoins(2147450880));
    }
}
