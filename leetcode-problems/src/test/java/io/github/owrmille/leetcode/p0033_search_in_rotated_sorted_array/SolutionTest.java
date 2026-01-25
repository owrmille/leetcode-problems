package io.github.owrmille.leetcode.p0033_search_in_rotated_sorted_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void example1() {
        Solution s = new Solution();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        assertEquals(4, s.search(nums, target));
    }

    @Test
    void example2() {
        Solution s = new Solution();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 3;

        assertEquals(-1, s.search(nums, target));
    }

    @Test
    void example3() {
        Solution s = new Solution();
        int[] nums = {1};
        int target = 0;

        assertEquals(-1, s.search(nums, target));
    }

    @Test
    void example4() {
        Solution s = new Solution();
        int[] nums = {3, 1};
        int target = 1;

        assertEquals(1, s.search(nums, target));
    }
}

// mvn test
// mvn -Dtest=SolutionTest test