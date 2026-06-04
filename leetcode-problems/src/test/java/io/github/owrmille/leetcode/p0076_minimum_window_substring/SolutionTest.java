package io.github.owrmille.leetcode.p0076_minimum_window_substring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void example1() {
         Solution s = new Solution();
         assertEquals("BANC", s.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    void example2() {
        Solution s = new Solution();
        assertEquals("a", s.minWindow("a", "a"));
    }

    @Test
    void example3() {
        Solution s = new Solution();
        assertEquals("", s.minWindow("a", "aa"));
    }
}

