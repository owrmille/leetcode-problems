package io.github.owrmille.leetcode.p0888_fair_candy_swap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void example1() {
        Solution s = new Solution();
        int[] alice = {1, 1};
        int[] bob = {2, 2};

        assertArrayEquals(new int[] {1, 2}, s.fairCandySwap(alice, bob));
    }

    @Test
    void example2() {
        Solution s = new Solution();
        int[] alice = {1, 2};
        int[] bob = {2, 3};

        assertArrayEquals(new int[] {1, 2}, s.fairCandySwap(alice, bob));
    }

    @Test
    void example3() {
        Solution s = new Solution();
        int[] alice = {2};
        int[] bob = {1, 3};

        assertArrayEquals(new int[] {2, 3}, s.fairCandySwap(alice, bob));
    }

    @Test
    void largerArrays() {
        Solution s = new Solution();
        int[] alice = {1, 2, 5, 7};
        int[] bob = {3, 4, 6, 8};

        assertArrayEquals(new int[] {1, 4}, s.fairCandySwap(alice, bob));
    }
}
