package io.github.owrmille.leetcode.p0125_valid_palindrome;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void example1() {
        Solution s = new Solution();
        assertTrue(s.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    void example2() {
        Solution s = new Solution();
        assertFalse(s.isPalindrome("race a car"));
    }

    @Test
    void example3() {
        Solution s = new Solution();
        assertTrue(s.isPalindrome("  "));
    }

    @Test
    void example4() {
        Solution s = new Solution();
        assertTrue(s.isPalindrome(".,"));
    }
}

