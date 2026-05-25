package io.github.owrmille.leetcode.p0209_minimum_size_subarray_sum;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void example1() {
        Solution s = new Solution();
        assertEquals(2, s.minSubArrayLen(7, new int[] { 2,3,1,2,4,3 }));
    }

    @Test
    void example2() {
        Solution s = new Solution();
        assertEquals(0, s.minSubArrayLen(11, new int[] { 1,1,1,1,1,1,1,1 }));
    }
}
