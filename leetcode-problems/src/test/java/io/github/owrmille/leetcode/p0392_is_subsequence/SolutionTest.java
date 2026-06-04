package io.github.owrmille.leetcode.p0392_is_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void example1() {
         Solution s = new Solution();
         assertTrue(s.isSubsequence("abc", "ahbgdc"));
    }

    @Test
    void example2() {
        Solution s = new Solution();
        assertFalse(s.isSubsequence("axc", "ahbgdc"));
    }
}

