package io.github.owrmille.leetcode.p1346_check_if_n_and_its_double_exist;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void example1() {
        Solution s = new Solution();
        int[] arr = {10, 2, 5, 3};

        assertTrue(s.checkIfExist(arr));
    }

    @Test
    void example2() {
        Solution s = new Solution();
        int[] arr = {7, 1, 14, 11};

        assertTrue(s.checkIfExist(arr));
    }

    @Test
    void example3() {
        Solution s = new Solution();
        int[] arr = {3, 1, 7, 11};

        assertFalse(s.checkIfExist(arr));
    }

    @Test
    void includesZero() {
        Solution s = new Solution();
        int[] arr = {0, 1};

        assertFalse(s.checkIfExist(arr));
    }

    @Test
    void includesZeroPair() {
        Solution s = new Solution();
        int[] arr = {0, 0, 1};

        assertTrue(s.checkIfExist(arr));
    }

    @Test
    void negativePair() {
        Solution s = new Solution();
        int[] arr = {-2, 0, 10, -4};

        assertTrue(s.checkIfExist(arr));
    }
}
